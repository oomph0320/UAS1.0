package com.example.util

import com.example.data.model.Question
import com.example.data.model.QuestionType
import com.example.data.model.QuizOption
import java.io.InputStream
import java.util.UUID
import java.util.zip.ZipInputStream

object QuestionParser {

    /**
     * Extracts plain text from Microsoft Word (.docx) documents by parsing word/document.xml.
     */
    fun extractTextFromDocx(inputStream: InputStream): String {
        val sb = StringBuilder()
        try {
            ZipInputStream(inputStream).use { zip ->
                var entry = zip.nextEntry
                while (entry != null) {
                    if (entry.name == "word/document.xml") {
                        val xmlContent = zip.bufferedReader(Charsets.UTF_8).readText()
                        val pRegex = Regex("""<w:p(?:\s[^>]*)?>(.*?)</w:p>""")
                        val tRegex = Regex("""<w:t(?:\s[^>]*)?>([^<]*)</w:t>""")
                        val paragraphs = pRegex.findAll(xmlContent)
                        for (p in paragraphs) {
                            val pText = StringBuilder()
                            for (t in tRegex.findAll(p.value)) {
                                pText.append(t.groupValues[1])
                            }
                            val line = decodeXmlEntities(pText.toString().trim())
                            if (line.isNotEmpty()) {
                                sb.append(line).append("\n")
                            }
                        }
                        break
                    }
                    entry = zip.nextEntry
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return sb.toString()
    }

    private fun decodeXmlEntities(text: String): String {
        return text.replace("&amp;", "&")
            .replace("&lt;", "<")
            .replace("&gt;", ">")
            .replace("&quot;", "\"")
            .replace("&apos;", "'")
    }

    fun parseRawText(text: String, defaultTopic: String = "无人机理论补充"): List<Question> {
        val trimmed = text.trim()
        if (trimmed.isEmpty()) return emptyList()

        // Normalize line breaks
        val normalized = trimmed.replace("\r\n", "\n").replace("\r", "\n")

        // Split by blocks: either section titles or numbered questions
        val regexSplit = Regex("""(?m)(?=^(?:[0-9]{1,4}[\.、\s]|[（(][0-9]{1,4}[）)]|[一二三四五六七八九十]+[、\.].*题))""")
        val rawBlocks = normalized.split(regexSplit).map { it.trim() }.filter { it.isNotEmpty() }

        val questionList = mutableListOf<Question>()
        var activeSectionTopic = defaultTopic

        for (block in rawBlocks) {
            // Check if this block is a section header like "一、单项选择题（每题2分，共20分）"
            val sectionMatch = Regex("""^[一二三四五六七八九十]+[、\.](.*题.*)""").find(block.lines().firstOrNull() ?: "")
            if (sectionMatch != null && block.lines().size <= 2 && !block.contains("答案")) {
                activeSectionTopic = sectionMatch.groupValues[1].replace(Regex("""[（(].*"""), "").trim()
                if (activeSectionTopic.isBlank()) activeSectionTopic = defaultTopic
                continue
            }

            val q = parseSingleBlock(block, activeSectionTopic)
            if (q != null) {
                questionList.add(q)
            }
        }

        return questionList
    }

    private fun parseSingleBlock(block: String, defaultTopic: String): Question? {
        val lines = block.lines().map { it.trim() }.filter { it.isNotEmpty() }
        if (lines.isEmpty()) return null

        var questionPrompt = ""
        val options = mutableListOf<QuizOption>()
        val answers = mutableListOf<String>()
        var explanation = ""
        var topic = defaultTopic

        // Clean prefix like "1.", "2、"
        val firstLine = lines.first().replaceFirst(Regex("""^[0-9]{1,4}[\.、\s]+"""), "").trim()
        questionPrompt = firstLine

        for (i in 1 until lines.size) {
            val line = lines[i]

            // Check if Answer line: "答案：A" or "【答案】AC" or "答案：C（微型无人机...）"
            val ansMatch = Regex("""^(?:【答案】|答案[：:]\s*)(.*)""").find(line)
            if (ansMatch != null) {
                val ansStr = ansMatch.groupValues[1].trim()
                extractAnswers(ansStr, answers) { extractedExp ->
                    if (explanation.isEmpty()) {
                        explanation = extractedExp
                    }
                }
                continue
            }

            // Check if Explanation line: "解析：..." or "【解析】..."
            val expMatch = Regex("""^(?:【解析】|解析[：:]\s*)(.*)""").find(line)
            if (expMatch != null) {
                explanation = expMatch.groupValues[1].trim()
                continue
            }

            // Check if Topic line: "分类：..." or "考点：..."
            val topicMatch = Regex("""^(?:【考点】|【分类】|分类[：:]\s*|考点[：:]\s*)(.*)""").find(line)
            if (topicMatch != null) {
                topic = topicMatch.groupValues[1].trim()
                continue
            }

            // Check if Option line: "A. xxx" or "A、xxx" or "A xxx"
            val optMatch = Regex("""^([A-G])[\.、\s]\s*(.*)""").find(line)
            if (optMatch != null) {
                val key = optMatch.groupValues[1].uppercase()
                val optText = optMatch.groupValues[2].trim()
                options.add(QuizOption(key, optText))
                continue
            }

            // Otherwise, append to question prompt if no options found yet
            if (options.isEmpty() && answers.isEmpty() && explanation.isEmpty()) {
                questionPrompt += " " + line
            } else if (explanation.isNotEmpty()) {
                explanation += " " + line
            }
        }

        if (questionPrompt.isBlank()) return null

        // Determine question type
        val type: QuestionType = when {
            // Options exist
            options.isNotEmpty() -> {
                if (answers.size > 1) {
                    QuestionType.MULTI
                } else if (answers.isNotEmpty() && answers.first().length > 1 && answers.first().all { it in 'A'..'Z' }) {
                    // e.g. answer is "ABC"
                    val single = answers.first()
                    answers.clear()
                    single.forEach { answers.add(it.toString()) }
                    QuestionType.MULTI
                } else {
                    QuestionType.SINGLE
                }
            }
            // Judgment (True/False)
            answers.any { it in listOf("对", "错", "正确", "错误", "TRUE", "FALSE") } ||
            questionPrompt.contains("判断题") ||
            (questionPrompt.endsWith("( )") || questionPrompt.endsWith("（ ）")) && answers.size == 1 && answers.first() in listOf("A", "B", "对", "错", "正确", "错误") -> {
                // normalize answer to A or B
                val isTrue = answers.firstOrNull() in listOf("对", "正确", "TRUE", "A")
                answers.clear()
                answers.add(if (isTrue) "A" else "B")
                options.clear()
                options.add(QuizOption("A", "正确"))
                options.add(QuizOption("B", "错误"))
                QuestionType.JUDGE
            }
            // Fill in the blank
            questionPrompt.contains("___") || questionPrompt.contains("____") -> {
                QuestionType.FILL
            }
            // Short answer
            else -> {
                QuestionType.SHORT
            }
        }

        return Question(
            id = "custom_" + UUID.randomUUID().toString().take(8),
            type = type,
            topic = topic,
            question = questionPrompt,
            options = options,
            answer = answers.ifEmpty { listOf("参考解析") },
            explanation = explanation
        )
    }

    private fun extractAnswers(ansStr: String, answers: MutableList<String>, onExplanationFound: (String) -> Unit) {
        val trimmed = ansStr.trim()
        
        // Handle bracketed explanations like "C（微型无人机飞行高度限制为50米，120米为轻型无人机上限）"
        // or "ABD (原因说明...)"
        val bracketMatch = Regex("""^([A-G]+|[对错正确错误TRUEFALSE]+|[^\s（(]+)\s*[（(](.*)[）)]\s*$""").find(trimmed)
        val pureAns = if (bracketMatch != null) {
            val exp = bracketMatch.groupValues[2].trim()
            if (exp.isNotEmpty()) {
                onExplanationFound(exp)
            }
            bracketMatch.groupValues[1].trim()
        } else {
            trimmed
        }

        val upper = pureAns.uppercase()
        if (upper.contains("正确") || upper == "对" || upper == "TRUE") {
            answers.add("A")
        } else if (upper.contains("错误") || upper == "错" || upper == "FALSE") {
            answers.add("B")
        } else {
            // Find letters A-G
            val letters = Regex("""[A-G]""").findAll(upper).map { it.value }.toList()
            if (letters.isNotEmpty()) {
                answers.addAll(letters)
            } else {
                // Plain text answer for fill-in-the-blank or short answer
                answers.add(pureAns)
            }
        }
    }
}
