package com.example

import com.example.data.initial.UavQuestionBank
import com.example.data.model.QuestionType
import com.example.util.QuestionParser
import org.junit.Assert.*
import org.junit.Test

class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun questionBank_containsAllQuestionTypes() {
        val all = UavQuestionBank.questions
        assertTrue(all.isNotEmpty())
        assertTrue("Single choice should exist", all.any { it.type == QuestionType.SINGLE })
        assertTrue("Multi choice should exist", all.any { it.type == QuestionType.MULTI })
        assertTrue("Judge should exist", all.any { it.type == QuestionType.JUDGE })
        assertTrue("Fill blank should exist", all.any { it.type == QuestionType.FILL })
        assertTrue("Short answer should exist", all.any { it.type == QuestionType.SHORT })
        
        // Ensure no duplicate IDs
        val ids = all.map { it.id }
        assertEquals("All question IDs should be distinct", ids.size, ids.distinct().size)
    }

    @Test
    fun questionParser_canParseSingleChoice() {
        val sample = """
            1. 根据《条例》，以下不属于微型无人机的是？
            A. 0.1kg
            B. 飞行高度限制120米
            C. 未安装抛投
            答案：B
            解析：微型无人机飞行高度限制为50米。
        """.trimIndent()

        val parsed = QuestionParser.parseRawText(sample)
        assertEquals(1, parsed.size)
        assertEquals(QuestionType.SINGLE, parsed[0].type)
        assertEquals(listOf("B"), parsed[0].answer)
        assertEquals(3, parsed[0].options.size)
    }
}
