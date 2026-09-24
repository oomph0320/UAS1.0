package com.example.data.model

enum class QuestionType(val code: String, val displayName: String) {
    SINGLE("single", "单选题"),
    MULTI("multi", "多选题"),
    JUDGE("judge", "判断题"),
    FILL("fill", "填空题"),
    SHORT("short", "简答题");

    companion object {
        fun fromCode(code: String): QuestionType {
            return entries.firstOrNull { it.code.equals(code, ignoreCase = true) } ?: SINGLE
        }
    }
}

data class QuizOption(
    val key: String,
    val text: String
)

data class Question(
    val id: String,
    val type: QuestionType,
    val question: String,
    val options: List<QuizOption> = emptyList(),
    val answer: List<String>,
    val explanation: String = "",
    val topic: String = "无人机综合理论",
    val difficulty: Int = 1
)

data class QuestionWithProgress(
    val question: Question,
    val selectedAnswers: List<String> = emptyList(),
    val textResponse: String = "",
    val isAnswered: Boolean = false,
    val isCorrect: Boolean? = null,
    val isRevealed: Boolean = false,
    val isWrong: Boolean = false,
    val isFavorite: Boolean = false,
    val note: String = ""
)

enum class QuizMode {
    PRACTICE, // 刷题判题
    MEMORIZE  // 背题速记（直接展示答案解析）
}
