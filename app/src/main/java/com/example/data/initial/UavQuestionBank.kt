package com.example.data.initial

import com.example.data.model.Question
import com.example.data.model.QuestionType

/**
 * 统揽全部考试资料的唯一大题库 (UAV Comprehensive Question Bank)
 * 不按文档分散，全量汇总并统一按题型管理：
 * - 单选题 (Single Choice)
 * - 多选题 (Multiple Choice)
 * - 判断题 (True / False)
 * - 填空题 (Fill-in-the-Blank)
 * - 简答与应用分析题 (Short Answer & Application)
 */
object UavQuestionBank {

    val questions: List<Question> by lazy {
        val list = mutableListOf<Question>()
        list.addAll(singleChoiceQuestionsPart1)
        list.addAll(singleChoiceQuestionsPart2)
        list.addAll(multiChoiceQuestions)
        list.addAll(judgeQuestions)
        list.addAll(fillBlankQuestions)
        list.addAll(shortAnswerQuestions)
        list
    }

    /**
     * 按题型快速过滤题库
     */
    fun getQuestionsByType(type: QuestionType): List<Question> {
        return questions.filter { it.type == type }
    }

    /**
     * 获取按题型统计数量
     */
    fun getTypeCounts(): Map<QuestionType, Int> {
        return QuestionType.entries.associateWith { type ->
            questions.count { it.type == type }
        }
    }
}
