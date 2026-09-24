package com.example.data.repository

import com.example.data.initial.UavQuestionBank
import com.example.data.local.QuestionDao
import com.example.data.local.QuestionEntity
import com.example.data.local.UserQuestionProgressEntity
import com.example.data.model.Question
import com.example.data.model.QuestionType
import com.example.data.model.QuestionWithProgress
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.combine

class QuizRepository(private val questionDao: QuestionDao) {

    suspend fun checkAndSeedDatabase() {
        val count = questionDao.getQuestionCount()
        val allEntities = UavQuestionBank.questions.map { QuestionEntity.fromDomain(it) }
        if (count < allEntities.size) {
            questionDao.insertAll(allEntities)
        }
    }

    suspend fun reloadDefaultBank() {
        val allEntities = UavQuestionBank.questions.map { QuestionEntity.fromDomain(it) }
        questionDao.insertAll(allEntities)
    }

    suspend fun addQuestions(questions: List<Question>) {
        val entities = questions.map { QuestionEntity.fromDomain(it) }
        questionDao.insertAll(entities)
    }

    fun getAllQuestionsWithProgress(): Flow<List<QuestionWithProgress>> {
        return combine(
            questionDao.getAllQuestions(),
            questionDao.getAllProgress()
        ) { questions, progressList ->
            val progressMap = progressList.associateBy { it.questionId }
            questions.map { entity ->
                val q = entity.toDomain()
                val p = progressMap[q.id]
                QuestionWithProgress(
                    question = q,
                    selectedAnswers = p?.selectedAnswers ?: emptyList(),
                    textResponse = p?.textResponse ?: "",
                    isAnswered = p?.isAnswered ?: false,
                    isCorrect = p?.isCorrect,
                    isRevealed = p?.isRevealed ?: false,
                    isWrong = p?.isWrong ?: false,
                    isFavorite = p?.isFavorite ?: false,
                    note = p?.note ?: ""
                )
            }
        }
    }

    fun getQuestionsByType(type: QuestionType?): Flow<List<QuestionWithProgress>> {
        val questionsFlow = if (type == null) {
            questionDao.getAllQuestions()
        } else {
            questionDao.getQuestionsByType(type.code)
        }

        return combine(
            questionsFlow,
            questionDao.getAllProgress()
        ) { questions, progressList ->
            val progressMap = progressList.associateBy { it.questionId }
            questions.map { entity ->
                val q = entity.toDomain()
                val p = progressMap[q.id]
                QuestionWithProgress(
                    question = q,
                    selectedAnswers = p?.selectedAnswers ?: emptyList(),
                    textResponse = p?.textResponse ?: "",
                    isAnswered = p?.isAnswered ?: false,
                    isCorrect = p?.isCorrect,
                    isRevealed = p?.isRevealed ?: false,
                    isWrong = p?.isWrong ?: false,
                    isFavorite = p?.isFavorite ?: false,
                    note = p?.note ?: ""
                )
            }
        }
    }

    fun searchQuestions(query: String): Flow<List<QuestionWithProgress>> {
        return combine(
            questionDao.searchQuestions(query),
            questionDao.getAllProgress()
        ) { questions, progressList ->
            val progressMap = progressList.associateBy { it.questionId }
            questions.map { entity ->
                val q = entity.toDomain()
                val p = progressMap[q.id]
                QuestionWithProgress(
                    question = q,
                    selectedAnswers = p?.selectedAnswers ?: emptyList(),
                    textResponse = p?.textResponse ?: "",
                    isAnswered = p?.isAnswered ?: false,
                    isCorrect = p?.isCorrect,
                    isRevealed = p?.isRevealed ?: false,
                    isWrong = p?.isWrong ?: false,
                    isFavorite = p?.isFavorite ?: false,
                    note = p?.note ?: ""
                )
            }
        }
    }

    suspend fun saveAnswer(
        questionId: String,
        selectedAnswers: List<String>,
        textResponse: String,
        isCorrect: Boolean?,
        isRevealed: Boolean,
        currentProgress: QuestionWithProgress?
    ) {
        val willBeWrong = if (isCorrect != null) {
            !isCorrect || (currentProgress?.isWrong == true && isCorrect == false)
        } else {
            currentProgress?.isWrong ?: false
        }

        val entity = UserQuestionProgressEntity(
            questionId = questionId,
            selectedAnswers = selectedAnswers,
            textResponse = textResponse,
            isAnswered = true,
            isCorrect = isCorrect,
            isRevealed = isRevealed,
            isWrong = willBeWrong,
            isFavorite = currentProgress?.isFavorite ?: false,
            note = currentProgress?.note ?: "",
            updatedAt = System.currentTimeMillis()
        )
        questionDao.upsertProgress(entity)
    }

    suspend fun revealAnswerOnly(questionId: String, currentProgress: QuestionWithProgress?) {
        val entity = UserQuestionProgressEntity(
            questionId = questionId,
            selectedAnswers = currentProgress?.selectedAnswers ?: emptyList(),
            textResponse = currentProgress?.textResponse ?: "",
            isAnswered = currentProgress?.isAnswered ?: false,
            isCorrect = currentProgress?.isCorrect,
            isRevealed = true,
            isWrong = currentProgress?.isWrong ?: false,
            isFavorite = currentProgress?.isFavorite ?: false,
            note = currentProgress?.note ?: "",
            updatedAt = System.currentTimeMillis()
        )
        questionDao.upsertProgress(entity)
    }

    suspend fun toggleFavorite(questionId: String, isFavorite: Boolean) {
        questionDao.setFavorite(questionId, isFavorite)
    }

    suspend fun saveNote(questionId: String, note: String) {
        questionDao.setNote(questionId, note)
    }

    suspend fun removeWrong(questionId: String) {
        questionDao.removeWrong(questionId)
    }

    suspend fun clearAllWrongs() {
        questionDao.clearAllWrongs()
    }

    suspend fun resetAllProgress() {
        questionDao.resetAllProgress()
    }
}
