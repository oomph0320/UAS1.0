package com.example.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.data.model.QuestionType
import com.example.data.model.QuestionWithProgress
import com.example.data.model.QuizMode
import com.example.data.model.SubjectCatalog
import com.example.data.model.SubjectInfo
import com.example.data.repository.QuizRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

enum class Screen {
    HOME,             // "无人机专家" 主页
    UAV_FOUNDATION,   // "无人机技术基础" 题库看板
    SUBJECT_DETAIL,   // 拓展科目详情与题库建设页
    QUIZ,
    WRONG_BOOK,
    FAVORITES,
    NOTES,
    EXAM,
    SEARCH
}

class QuizViewModel(private val repository: QuizRepository) : ViewModel() {

    private val _currentScreen = MutableStateFlow(Screen.HOME)
    val currentScreen: StateFlow<Screen> = _currentScreen.asStateFlow()

    private val _selectedSubject = MutableStateFlow<SubjectInfo>(SubjectCatalog.PRIMARY_SUBJECT)
    val selectedSubject: StateFlow<SubjectInfo> = _selectedSubject.asStateFlow()

    private val _activeTypeFilter = MutableStateFlow<QuestionType?>(null)
    val activeTypeFilter: StateFlow<QuestionType?> = _activeTypeFilter.asStateFlow()

    private val _quizMode = MutableStateFlow(QuizMode.PRACTICE)
    val quizMode: StateFlow<QuizMode> = _quizMode.asStateFlow()

    private val _isRandomOrder = MutableStateFlow(false)
    val isRandomOrder: StateFlow<Boolean> = _isRandomOrder.asStateFlow()

    // Master list of all questions with user progress
    val allQuestionsWithProgress: StateFlow<List<QuestionWithProgress>> =
        repository.getAllQuestionsWithProgress().stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = emptyList()
        )

    // Current quiz session pool
    private val _quizPool = MutableStateFlow<List<QuestionWithProgress>>(emptyList())
    val quizPool: StateFlow<List<QuestionWithProgress>> = _quizPool.asStateFlow()

    private val _currentIndex = MutableStateFlow(0)
    val currentIndex: StateFlow<Int> = _currentIndex.asStateFlow()

    // Temporary local draft inputs during a quiz
    private val _selectedKeys = MutableStateFlow<List<String>>(emptyList())
    val selectedKeys: StateFlow<List<String>> = _selectedKeys.asStateFlow()

    private val _textResponseDraft = MutableStateFlow("")
    val textResponseDraft: StateFlow<String> = _textResponseDraft.asStateFlow()

    private val _searchQuery = MutableStateFlow("")
    val searchQuery: StateFlow<String> = _searchQuery.asStateFlow()

    // Title / description of the active session
    private val _sessionTitle = MutableStateFlow("无人机综合练习")
    val sessionTitle: StateFlow<String> = _sessionTitle.asStateFlow()

    // Exam countdown timer in seconds (e.g. 45 min = 2700s)
    private val _examRemainingSeconds = MutableStateFlow(2700)
    val examRemainingSeconds: StateFlow<Int> = _examRemainingSeconds.asStateFlow()

    private val _isExamSubmitted = MutableStateFlow(false)
    val isExamSubmitted: StateFlow<Boolean> = _isExamSubmitted.asStateFlow()

    init {
        viewModelScope.launch {
            repository.checkAndSeedDatabase()
        }
    }

    fun navigateTo(screen: Screen) {
        _currentScreen.value = screen
    }

    fun setQuizMode(mode: QuizMode) {
        _quizMode.value = mode
    }

    fun setRandomOrder(random: Boolean) {
        _isRandomOrder.value = random
    }

    fun startQuizByType(type: QuestionType?) {
        _activeTypeFilter.value = type
        _sessionTitle.value = type?.displayName ?: "全部题型 · 综合练习"
        val all = allQuestionsWithProgress.value
        val filtered = if (type == null) all else all.filter { it.question.type == type }
        if (filtered.isEmpty()) return

        val pool = if (_isRandomOrder.value) filtered.shuffled() else filtered
        _quizPool.value = pool
        _currentIndex.value = 0
        syncCurrentQuestionDraft(pool.firstOrNull())
        _currentScreen.value = Screen.QUIZ
    }

    fun startWrongQuestionsQuiz(typeFilter: QuestionType? = null) {
        val all = allQuestionsWithProgress.value
        val wrongs = all.filter { it.isWrong }
        val filtered = if (typeFilter == null) wrongs else wrongs.filter { it.question.type == typeFilter }
        if (filtered.isEmpty()) return

        _sessionTitle.value = if (typeFilter != null) "错题专项 · ${typeFilter.displayName}" else "错题本 · 专项强化"
        _quizPool.value = if (_isRandomOrder.value) filtered.shuffled() else filtered
        _currentIndex.value = 0
        syncCurrentQuestionDraft(_quizPool.value.firstOrNull())
        _currentScreen.value = Screen.QUIZ
    }

    fun startFavoritesQuiz() {
        val all = allQuestionsWithProgress.value
        val favs = all.filter { it.isFavorite }
        if (favs.isEmpty()) return

        _sessionTitle.value = "收藏夹 · 重点巩固"
        _quizPool.value = if (_isRandomOrder.value) favs.shuffled() else favs
        _currentIndex.value = 0
        syncCurrentQuestionDraft(_quizPool.value.firstOrNull())
        _currentScreen.value = Screen.QUIZ
    }

    fun startSimulatedExam() {
        val all = allQuestionsWithProgress.value
        if (all.isEmpty()) return

        // Pick an authentic exam distribution: 15 single, 6 multi, 8 judge, 4 fill, 2 short (or max available)
        val singles = all.filter { it.question.type == QuestionType.SINGLE }.shuffled().take(15)
        val multis = all.filter { it.question.type == QuestionType.MULTI }.shuffled().take(6)
        val judges = all.filter { it.question.type == QuestionType.JUDGE }.shuffled().take(8)
        val fills = all.filter { it.question.type == QuestionType.FILL }.shuffled().take(4)
        val shorts = all.filter { it.question.type == QuestionType.SHORT }.shuffled().take(2)

        val examList = (singles + multis + judges + fills + shorts).ifEmpty { all.shuffled().take(30) }
        _sessionTitle.value = "无人机执照全真模拟考试"
        _quizPool.value = examList
        _currentIndex.value = 0
        _examRemainingSeconds.value = 2700 // 45 minutes
        _isExamSubmitted.value = false
        syncCurrentQuestionDraft(examList.firstOrNull())
        _currentScreen.value = Screen.EXAM
    }

    private fun syncCurrentQuestionDraft(item: QuestionWithProgress?) {
        if (item == null) {
            _selectedKeys.value = emptyList()
            _textResponseDraft.value = ""
            return
        }
        _selectedKeys.value = item.selectedAnswers
        _textResponseDraft.value = item.textResponse
    }

    fun jumpToQuestion(index: Int) {
        val pool = _quizPool.value
        if (index in pool.indices) {
            _currentIndex.value = index
            syncCurrentQuestionDraft(pool[index])
        }
    }

    fun nextQuestion() {
        val pool = _quizPool.value
        if (_currentIndex.value < pool.size - 1) {
            jumpToQuestion(_currentIndex.value + 1)
        }
    }

    fun prevQuestion() {
        if (_currentIndex.value > 0) {
            jumpToQuestion(_currentIndex.value - 1)
        }
    }

    fun onOptionClicked(key: String) {
        val pool = _quizPool.value
        val item = pool.getOrNull(_currentIndex.value) ?: return
        if (item.isAnswered && _quizMode.value == QuizMode.PRACTICE) return

        when (item.question.type) {
            QuestionType.SINGLE, QuestionType.JUDGE -> {
                _selectedKeys.value = listOf(key)
                // In practice mode, single choice / judge immediately auto-submits
                if (_quizMode.value == QuizMode.PRACTICE) {
                    val isCorrect = item.question.answer.contains(key)
                    recordAnswer(item, listOf(key), "", isCorrect, isRevealed = true)
                }
            }
            QuestionType.MULTI -> {
                val current = _selectedKeys.value.toMutableList()
                if (current.contains(key)) {
                    current.remove(key)
                } else {
                    current.add(key)
                }
                _selectedKeys.value = current
            }
            else -> {}
        }
    }

    fun submitMultiChoice() {
        val pool = _quizPool.value
        val item = pool.getOrNull(_currentIndex.value) ?: return
        val selected = _selectedKeys.value.sorted()
        if (selected.isEmpty()) return

        val expected = item.question.answer.sorted()
        val isCorrect = selected == expected
        recordAnswer(item, selected, "", isCorrect, isRevealed = true)
    }

    fun updateTextResponseDraft(text: String) {
        _textResponseDraft.value = text
    }

    fun submitFillInAnswer() {
        val pool = _quizPool.value
        val item = pool.getOrNull(_currentIndex.value) ?: return
        val response = _textResponseDraft.value.trim()
        if (response.isEmpty()) return

        // Normalize text check
        val normalizedResponse = response.replace(Regex("[\\s,，、。；;]+"), "").lowercase()
        val isAutoMatch = item.question.answer.any { ans ->
            val normAns = ans.replace(Regex("[\\s,，、。；;]+"), "").lowercase()
            normalizedResponse == normAns
        }

        recordAnswer(
            item = item,
            selected = emptyList(),
            text = response,
            isCorrect = if (isAutoMatch) true else null,
            isRevealed = true
        )
    }

    fun submitShortAnswer() {
        val pool = _quizPool.value
        val item = pool.getOrNull(_currentIndex.value) ?: return
        val response = _textResponseDraft.value.trim()

        recordAnswer(
            item = item,
            selected = emptyList(),
            text = response,
            isCorrect = null, // waits for self-grade
            isRevealed = true
        )
    }

    fun selfGrade(isCorrect: Boolean) {
        val pool = _quizPool.value
        val item = pool.getOrNull(_currentIndex.value) ?: return
        recordAnswer(
            item = item,
            selected = _selectedKeys.value,
            text = _textResponseDraft.value,
            isCorrect = isCorrect,
            isRevealed = true
        )
    }

    fun revealAnswer() {
        val pool = _quizPool.value
        val item = pool.getOrNull(_currentIndex.value) ?: return
        viewModelScope.launch {
            repository.revealAnswerOnly(item.question.id, item)
            // Update in local pool
            updateLocalPoolItem(item.question.id) {
                it.copy(isRevealed = true)
            }
        }
    }

    private fun recordAnswer(
        item: QuestionWithProgress,
        selected: List<String>,
        text: String,
        isCorrect: Boolean?,
        isRevealed: Boolean
    ) {
        viewModelScope.launch {
            repository.saveAnswer(
                questionId = item.question.id,
                selectedAnswers = selected,
                textResponse = text,
                isCorrect = isCorrect,
                isRevealed = isRevealed,
                currentProgress = item
            )
            updateLocalPoolItem(item.question.id) {
                it.copy(
                    selectedAnswers = selected,
                    textResponse = text,
                    isAnswered = true,
                    isCorrect = isCorrect,
                    isRevealed = isRevealed,
                    isWrong = if (isCorrect != null) !isCorrect else it.isWrong
                )
            }
        }
    }

    private fun updateLocalPoolItem(questionId: String, transform: (QuestionWithProgress) -> QuestionWithProgress) {
        val updated = _quizPool.value.map {
            if (it.question.id == questionId) transform(it) else it
        }
        _quizPool.value = updated
    }

    fun toggleFavorite(questionId: String) {
        val current = allQuestionsWithProgress.value.firstOrNull { it.question.id == questionId }
        val newFav = !(current?.isFavorite ?: false)
        viewModelScope.launch {
            repository.toggleFavorite(questionId, newFav)
            updateLocalPoolItem(questionId) { it.copy(isFavorite = newFav) }
        }
    }

    fun saveNote(questionId: String, note: String) {
        viewModelScope.launch {
            repository.saveNote(questionId, note)
            updateLocalPoolItem(questionId) { it.copy(note = note) }
        }
    }

    fun removeWrong(questionId: String) {
        viewModelScope.launch {
            repository.removeWrong(questionId)
            updateLocalPoolItem(questionId) { it.copy(isWrong = false) }
        }
    }

    fun openSubject(subject: SubjectInfo) {
        _selectedSubject.value = subject
        if (subject.isPrimary) {
            _currentScreen.value = Screen.UAV_FOUNDATION
        } else {
            _currentScreen.value = Screen.SUBJECT_DETAIL
        }
    }

    fun startSubjectWrongQuiz(subject: SubjectInfo) {
        val all = allQuestionsWithProgress.value
        val wrongs = all.filter {
            val matchesSubject = if (subject.isPrimary) {
                it.question.topic.contains(subject.title) ||
                SubjectCatalog.EXTENSION_SUBJECTS.none { ext -> it.question.topic.contains(ext.title) }
            } else {
                it.question.topic.contains(subject.title) || it.question.topic == subject.title
            }
            matchesSubject && it.isWrong
        }
        if (wrongs.isEmpty()) return

        _sessionTitle.value = "${subject.title} · 错题专项强化"
        _quizPool.value = if (_isRandomOrder.value) wrongs.shuffled() else wrongs
        _currentIndex.value = 0
        syncCurrentQuestionDraft(_quizPool.value.firstOrNull())
        _currentScreen.value = Screen.QUIZ
    }

    fun startSubjectQuiz(subject: SubjectInfo, type: QuestionType? = null) {
        val all = allQuestionsWithProgress.value
        val filtered = if (subject.isPrimary) {
            val primary = all.filter {
                it.question.topic.contains(subject.title) ||
                SubjectCatalog.EXTENSION_SUBJECTS.none { ext -> it.question.topic.contains(ext.title) }
            }
            if (type != null) primary.filter { it.question.type == type } else primary
        } else {
            val subQuestions = all.filter {
                it.question.topic.contains(subject.title) || it.question.topic == subject.title
            }
            if (type != null) subQuestions.filter { it.question.type == type } else subQuestions
        }

        if (filtered.isEmpty()) return

        val ordered = if (_isRandomOrder.value) filtered.shuffled() else filtered
        val typeName = when (type) {
            QuestionType.SINGLE -> "单选题"
            QuestionType.MULTI -> "多选题"
            QuestionType.JUDGE -> "判断题"
            QuestionType.FILL -> "填空题"
            QuestionType.SHORT -> "简答题"
            null -> "全部试题"
        }
        _sessionTitle.value = "${subject.title} · $typeName"
        _quizPool.value = ordered
        _currentIndex.value = 0
        syncCurrentQuestionDraft(ordered.firstOrNull())
        _currentScreen.value = Screen.QUIZ
    }

    fun importQuestionsForSubject(subject: SubjectInfo, rawText: String, onResult: (Int) -> Unit) {
        importQuestionsFromText(rawText, defaultTopic = subject.title, onResult = onResult)
    }

    fun clearAllWrongs() {
        viewModelScope.launch {
            repository.clearAllWrongs()
            val cleared = _quizPool.value.map { it.copy(isWrong = false) }
            _quizPool.value = cleared
        }
    }

    fun setSearchQuery(query: String) {
        _searchQuery.value = query
    }

    fun importQuestionsFromText(rawText: String, defaultTopic: String = "无人机理论补充", onResult: (Int) -> Unit) {
        viewModelScope.launch {
            val parsed = com.example.util.QuestionParser.parseRawText(rawText, defaultTopic)
            if (parsed.isNotEmpty()) {
                repository.addQuestions(parsed)
            }
            onResult(parsed.size)
        }
    }

    fun resetAllStudyRecords() {
        viewModelScope.launch {
            repository.resetAllProgress()
            _quizPool.value = _quizPool.value.map {
                it.copy(
                    selectedAnswers = emptyList(),
                    textResponse = "",
                    isAnswered = false,
                    isCorrect = null,
                    isRevealed = false,
                    isWrong = false,
                    isFavorite = false,
                    note = ""
                )
            }
            _selectedKeys.value = emptyList()
            _textResponseDraft.value = ""
        }
    }

    fun reloadDefaultBank(onComplete: () -> Unit = {}) {
        viewModelScope.launch {
            repository.reloadDefaultBank()
            onComplete()
        }
    }
}

class QuizViewModelFactory(private val repository: QuizRepository) : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(QuizViewModel::class.java)) {
            return QuizViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
