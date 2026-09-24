package com.example

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.BackHandler
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.data.local.AppDatabase
import com.example.data.repository.QuizRepository
import com.example.ui.screens.ExamScreen
import com.example.ui.screens.ExpertHomeScreen
import com.example.ui.screens.FavoritesAndNotesScreen
import com.example.ui.screens.HomeScreen
import com.example.ui.screens.QuizScreen
import com.example.ui.screens.SearchScreen
import com.example.ui.screens.SubjectDetailScreen
import com.example.ui.screens.WrongBookScreen
import com.example.ui.theme.UAVQuizTheme
import com.example.ui.viewmodel.QuizViewModel
import com.example.ui.viewmodel.QuizViewModelFactory
import com.example.ui.viewmodel.Screen

class MainActivity : ComponentActivity() {

    private val viewModel: QuizViewModel by viewModels {
        val db = AppDatabase.getInstance(applicationContext)
        val repository = QuizRepository(db.questionDao())
        QuizViewModelFactory(repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            UAVQuizTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    UavQuizApp(viewModel)
                }
            }
        }
    }
}

@Composable
fun UavQuizApp(viewModel: QuizViewModel) {
    val currentScreen by viewModel.currentScreen.collectAsStateWithLifecycle()
    val allQuestions by viewModel.allQuestionsWithProgress.collectAsStateWithLifecycle()
    val quizPool by viewModel.quizPool.collectAsStateWithLifecycle()
    val currentIndex by viewModel.currentIndex.collectAsStateWithLifecycle()
    val quizMode by viewModel.quizMode.collectAsStateWithLifecycle()
    val isRandomOrder by viewModel.isRandomOrder.collectAsStateWithLifecycle()
    val sessionTitle by viewModel.sessionTitle.collectAsStateWithLifecycle()
    val selectedKeys by viewModel.selectedKeys.collectAsStateWithLifecycle()
    val textResponseDraft by viewModel.textResponseDraft.collectAsStateWithLifecycle()
    val selectedSubject by viewModel.selectedSubject.collectAsStateWithLifecycle()

    // Handle system back navigation
    BackHandler(enabled = currentScreen != Screen.HOME) {
        viewModel.navigateTo(Screen.HOME)
    }

    when (currentScreen) {
        Screen.HOME -> {
            ExpertHomeScreen(
                allQuestions = allQuestions,
                onOpenSubject = { viewModel.openSubject(it) },
                onNavigate = { viewModel.navigateTo(it) },
                onStartExam = { viewModel.startSimulatedExam() },
                onImportText = { text, callback ->
                    viewModel.importQuestionsFromText(text, onResult = callback)
                },
                onReloadDefaultBank = { callback ->
                    viewModel.reloadDefaultBank {
                        callback(viewModel.allQuestionsWithProgress.value.size)
                    }
                }
            )
        }

        Screen.UAV_FOUNDATION -> {
            val primaryQuestions = allQuestions.filter {
                it.question.topic.contains(com.example.data.model.SubjectCatalog.PRIMARY_SUBJECT.title) ||
                com.example.data.model.SubjectCatalog.EXTENSION_SUBJECTS.none { ext -> it.question.topic.contains(ext.title) }
            }
            HomeScreen(
                allQuestions = primaryQuestions,
                quizMode = quizMode,
                isRandomOrder = isRandomOrder,
                onSetQuizMode = { viewModel.setQuizMode(it) },
                onSetRandomOrder = { viewModel.setRandomOrder(it) },
                onStartQuizByType = { viewModel.startSubjectQuiz(com.example.data.model.SubjectCatalog.PRIMARY_SUBJECT, it) },
                onNavigate = { viewModel.navigateTo(it) },
                onStartExam = { viewModel.startSimulatedExam() },
                onImportText = { text, callback ->
                    viewModel.importQuestionsFromText(text, onResult = callback)
                },
                onReloadDefaultBank = { callback ->
                    viewModel.reloadDefaultBank {
                        callback(viewModel.allQuestionsWithProgress.value.size)
                    }
                },
                onBackToExpertHome = {
                    viewModel.navigateTo(Screen.HOME)
                }
            )
        }

        Screen.SUBJECT_DETAIL -> {
            SubjectDetailScreen(
                subject = selectedSubject,
                allQuestions = allQuestions,
                quizMode = quizMode,
                isRandomOrder = isRandomOrder,
                onSetQuizMode = { viewModel.setQuizMode(it) },
                onSetRandomOrder = { viewModel.setRandomOrder(it) },
                onBackClick = { viewModel.navigateTo(Screen.HOME) },
                onStartQuiz = { subject, type ->
                    viewModel.startSubjectQuiz(subject, type)
                },
                onStartWrongQuiz = { subject ->
                    viewModel.startSubjectWrongQuiz(subject)
                },
                onImportTextForSubject = { text, callback ->
                    viewModel.importQuestionsForSubject(selectedSubject, text, callback)
                }
            )
        }

        Screen.QUIZ -> {
            QuizScreen(
                title = sessionTitle,
                pool = quizPool,
                currentIndex = currentIndex,
                quizMode = quizMode,
                selectedKeys = selectedKeys,
                textResponseDraft = textResponseDraft,
                onBackClick = { viewModel.navigateTo(Screen.HOME) },
                onOptionClick = { viewModel.onOptionClicked(it) },
                onSubmitMulti = { viewModel.submitMultiChoice() },
                onTextDraftChange = { viewModel.updateTextResponseDraft(it) },
                onSubmitFill = { viewModel.submitFillInAnswer() },
                onSubmitShort = { viewModel.submitShortAnswer() },
                onSelfGrade = { viewModel.selfGrade(it) },
                onRevealAnswer = { viewModel.revealAnswer() },
                onToggleFavorite = { viewModel.toggleFavorite(it) },
                onSaveNote = { qId, note -> viewModel.saveNote(qId, note) },
                onJumpToQuestion = { viewModel.jumpToQuestion(it) },
                onNextQuestion = { viewModel.nextQuestion() },
                onPrevQuestion = { viewModel.prevQuestion() }
            )
        }

        Screen.WRONG_BOOK -> {
            WrongBookScreen(
                allQuestions = allQuestions,
                onBackClick = { viewModel.navigateTo(Screen.HOME) },
                onStartWrongQuiz = { viewModel.startWrongQuestionsQuiz(it) },
                onRemoveWrong = { viewModel.removeWrong(it) },
                onClearAllWrongs = { viewModel.clearAllWrongs() }
            )
        }

        Screen.FAVORITES, Screen.NOTES -> {
            FavoritesAndNotesScreen(
                allQuestions = allQuestions,
                onBackClick = { viewModel.navigateTo(Screen.HOME) },
                onStartFavoritesQuiz = { viewModel.startFavoritesQuiz() },
                onToggleFavorite = { viewModel.toggleFavorite(it) },
                onDeleteNote = { viewModel.saveNote(it, "") }
            )
        }

        Screen.EXAM -> {
            ExamScreen(
                pool = quizPool,
                currentIndex = currentIndex,
                selectedKeys = selectedKeys,
                textResponseDraft = textResponseDraft,
                onBackClick = { viewModel.navigateTo(Screen.HOME) },
                onOptionClick = { viewModel.onOptionClicked(it) },
                onSubmitMulti = { viewModel.submitMultiChoice() },
                onTextDraftChange = { viewModel.updateTextResponseDraft(it) },
                onSubmitFill = { viewModel.submitFillInAnswer() },
                onSubmitShort = { viewModel.submitShortAnswer() },
                onSelfGrade = { viewModel.selfGrade(it) },
                onJumpToQuestion = { viewModel.jumpToQuestion(it) },
                onNextQuestion = { viewModel.nextQuestion() },
                onPrevQuestion = { viewModel.prevQuestion() }
            )
        }

        Screen.SEARCH -> {
            SearchScreen(
                allQuestions = allQuestions,
                onBackClick = { viewModel.navigateTo(Screen.HOME) },
                onSelectQuestion = { item ->
                    // Jump to single-item quiz or start quiz from that item
                    viewModel.startQuizByType(item.question.type)
                }
            )
        }
    }
}
