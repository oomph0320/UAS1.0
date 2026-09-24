package com.example.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.data.model.Question
import com.example.data.model.QuestionType
import com.example.data.model.QuizOption

@Entity(tableName = "questions")
data class QuestionEntity(
    @PrimaryKey val id: String,
    val type: String, // "single", "multi", "judge", "fill", "short"
    val question: String,
    val options: List<QuizOption>,
    val answer: List<String>,
    val explanation: String,
    val topic: String,
    val difficulty: Int
) {
    fun toDomain(): Question {
        return Question(
            id = id,
            type = QuestionType.fromCode(type),
            question = question,
            options = options,
            answer = answer,
            explanation = explanation,
            topic = topic,
            difficulty = difficulty
        )
    }

    companion object {
        fun fromDomain(q: Question): QuestionEntity {
            return QuestionEntity(
                id = q.id,
                type = q.type.code,
                question = q.question,
                options = q.options,
                answer = q.answer,
                explanation = q.explanation,
                topic = q.topic,
                difficulty = q.difficulty
            )
        }
    }
}

@Entity(tableName = "user_progress")
data class UserQuestionProgressEntity(
    @PrimaryKey val questionId: String,
    val selectedAnswers: List<String> = emptyList(),
    val textResponse: String = "",
    val isAnswered: Boolean = false,
    val isCorrect: Boolean? = null,
    val isRevealed: Boolean = false,
    val isWrong: Boolean = false,
    val isFavorite: Boolean = false,
    val note: String = "",
    val updatedAt: Long = System.currentTimeMillis()
)
