package com.example.ui.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.EditNote
import androidx.compose.material.icons.filled.Lightbulb
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.StarBorder
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.model.QuestionType
import com.example.data.model.QuestionWithProgress
import com.example.data.model.QuizMode
import com.example.ui.theme.AmberReview
import com.example.ui.theme.AmberReviewBg
import com.example.ui.theme.AmberReviewDarkBg
import com.example.ui.theme.CyanAccent
import com.example.ui.theme.CyanPrimary
import com.example.ui.theme.GreenCorrect
import com.example.ui.theme.GreenCorrectBg
import com.example.ui.theme.GreenCorrectBorder
import com.example.ui.theme.GreenCorrectDarkBg
import com.example.ui.theme.GreenCorrectDarkText
import com.example.ui.theme.GreenCorrectLightText
import com.example.ui.theme.RedWrong
import com.example.ui.theme.RedWrongBg
import com.example.ui.theme.RedWrongBorder
import com.example.ui.theme.RedWrongDarkBg
import com.example.ui.theme.RedWrongDarkText
import com.example.ui.theme.RedWrongLightText

@Composable
fun QuestionCard(
    item: QuestionWithProgress,
    quizMode: QuizMode,
    selectedKeys: List<String>,
    textResponseDraft: String,
    onOptionClick: (String) -> Unit,
    onSubmitMulti: () -> Unit,
    onTextDraftChange: (String) -> Unit,
    onSubmitFill: () -> Unit,
    onSubmitShort: () -> Unit,
    onSelfGrade: (Boolean) -> Unit,
    onRevealAnswer: () -> Unit,
    onToggleFavorite: () -> Unit,
    onSaveNote: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    val q = item.question
    var showNoteEditor by remember(item.question.id) { mutableStateOf(item.note.isNotBlank()) }
    var currentNoteText by remember(item.question.id, item.note) { mutableStateOf(item.note) }

    val isRevealed = quizMode == QuizMode.MEMORIZE || item.isRevealed

    Card(
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        modifier = modifier
            .fillMaxWidth()
            .testTag("question_card_${q.id}")
    ) {
        Column(modifier = Modifier.padding(20.dp)) {
            // Header: Type badge, Topic tag, Favorite button
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Surface(
                        color = MaterialTheme.colorScheme.primaryContainer,
                        shape = RoundedCornerShape(8.dp)
                    ) {
                        Text(
                            text = q.type.displayName,
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.primary,
                            modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                        )
                    }

                    Spacer(modifier = Modifier.width(8.dp))

                    Text(
                        text = q.topic,
                        fontSize = 12.sp,
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        maxLines = 1
                    )
                }

                Row(verticalAlignment = Alignment.CenterVertically) {
                    IconButton(
                        onClick = onToggleFavorite,
                        modifier = Modifier.size(36.dp).testTag("fav_button_${q.id}")
                    ) {
                        Icon(
                            imageVector = if (item.isFavorite) Icons.Filled.Star else Icons.Outlined.StarBorder,
                            contentDescription = if (item.isFavorite) "取消收藏" else "收藏题目",
                            tint = if (item.isFavorite) AmberReview else MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }

                    IconButton(
                        onClick = { showNoteEditor = !showNoteEditor },
                        modifier = Modifier.size(36.dp).testTag("note_toggle_${q.id}")
                    ) {
                        Icon(
                            imageVector = Icons.Default.EditNote,
                            contentDescription = "记录笔记",
                            tint = if (item.note.isNotBlank()) CyanAccent else MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(14.dp))

            // Question prompt text
            Text(
                text = q.question,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.SemiBold,
                lineHeight = 24.sp,
                color = MaterialTheme.colorScheme.onSurface
            )

            Spacer(modifier = Modifier.height(18.dp))

            // Options or inputs based on question type
            when (q.type) {
                QuestionType.SINGLE, QuestionType.JUDGE, QuestionType.MULTI -> {
                    OptionsList(
                        options = q.options,
                        type = q.type,
                        selectedKeys = if (isRevealed) item.selectedAnswers else selectedKeys,
                        correctAnswers = q.answer,
                        isRevealed = isRevealed,
                        onOptionClick = onOptionClick
                    )

                    if (q.type == QuestionType.MULTI && !isRevealed) {
                        Spacer(modifier = Modifier.height(14.dp))
                        Button(
                            onClick = onSubmitMulti,
                            enabled = selectedKeys.isNotEmpty(),
                            shape = RoundedCornerShape(12.dp),
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(46.dp)
                                .testTag("submit_multi_button")
                        ) {
                            Text("确认提交 (${selectedKeys.size}项已选)", fontWeight = FontWeight.Bold)
                        }
                    }
                }

                QuestionType.FILL -> {
                    FillInTheBlankInput(
                        responseDraft = textResponseDraft,
                        recordedResponse = item.textResponse,
                        isRevealed = isRevealed,
                        onDraftChange = onTextDraftChange,
                        onSubmit = onSubmitFill
                    )
                }

                QuestionType.SHORT -> {
                    ShortAnswerInput(
                        responseDraft = textResponseDraft,
                        recordedResponse = item.textResponse,
                        isRevealed = isRevealed,
                        onDraftChange = onTextDraftChange,
                        onSubmit = onSubmitShort
                    )
                }
            }

            // Results and Explanations
            AnimatedVisibility(
                visible = isRevealed,
                enter = fadeIn() + expandVertically(),
                exit = fadeOut() + shrinkVertically()
            ) {
                ExplanationBox(
                    item = item,
                    quizMode = quizMode,
                    onSelfGrade = onSelfGrade
                )
            }

            // Quick Peek Button (if in practice mode and not answered yet)
            if (quizMode == QuizMode.PRACTICE && !isRevealed) {
                Spacer(modifier = Modifier.height(12.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.End
                ) {
                    OutlinedButton(
                        onClick = onRevealAnswer,
                        shape = RoundedCornerShape(10.dp),
                        modifier = Modifier.testTag("reveal_answer_button")
                    ) {
                        Icon(Icons.Default.Lightbulb, contentDescription = null, modifier = Modifier.size(16.dp))
                        Spacer(modifier = Modifier.width(6.dp))
                        Text("直接看答案与解析", fontSize = 13.sp)
                    }
                }
            }

            // Inline Note Editor
            AnimatedVisibility(visible = showNoteEditor) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 16.dp)
                ) {
                    OutlinedTextField(
                        value = currentNoteText,
                        onValueChange = {
                            currentNoteText = it
                            onSaveNote(it)
                        },
                        placeholder = { Text("写下本题记忆口诀、法规考点或易错原因...", fontSize = 13.sp) },
                        shape = RoundedCornerShape(12.dp),
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedBorderColor = CyanAccent,
                            unfocusedBorderColor = MaterialTheme.colorScheme.outlineVariant
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(90.dp)
                            .testTag("note_input_${q.id}")
                    )
                }
            }
        }
    }
}

private data class OptionStyle(
    val bgColor: Color,
    val borderColor: Color,
    val textColor: Color,
    val circleBg: Color,
    val circleTextColor: Color,
    val badgeBg: Color,
    val badgeTextColor: Color,
    val badgeText: String?
)

@Composable
private fun OptionsList(
    options: List<com.example.data.model.QuizOption>,
    type: QuestionType,
    selectedKeys: List<String>,
    correctAnswers: List<String>,
    isRevealed: Boolean,
    onOptionClick: (String) -> Unit
) {
    val isDark = isSystemInDarkTheme()

    Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
        options.forEach { opt ->
            val isSelected = selectedKeys.contains(opt.key)
            val isCorrectOption = correctAnswers.contains(opt.key)

            val style = when {
                isRevealed && isCorrectOption -> {
                    OptionStyle(
                        bgColor = if (isDark) GreenCorrectDarkBg else GreenCorrectBg,
                        borderColor = GreenCorrect,
                        textColor = if (isDark) GreenCorrectDarkText else GreenCorrectLightText,
                        circleBg = GreenCorrect,
                        circleTextColor = Color.White,
                        badgeBg = GreenCorrect,
                        badgeTextColor = Color.White,
                        badgeText = if (isSelected) "✓ 你的正确作答" else "✓ 正确答案"
                    )
                }
                isRevealed && isSelected && !isCorrectOption -> {
                    OptionStyle(
                        bgColor = if (isDark) RedWrongDarkBg else RedWrongBg,
                        borderColor = RedWrong,
                        textColor = if (isDark) RedWrongDarkText else RedWrongLightText,
                        circleBg = RedWrong,
                        circleTextColor = Color.White,
                        badgeBg = RedWrong,
                        badgeTextColor = Color.White,
                        badgeText = "✕ 你的错误选择"
                    )
                }
                isSelected -> {
                    OptionStyle(
                        bgColor = if (isDark) Color(0xFF133654) else Color(0xFFE0F2FE),
                        borderColor = CyanAccent,
                        textColor = if (isDark) Color.White else Color(0xFF0369A1),
                        circleBg = CyanPrimary,
                        circleTextColor = Color.White,
                        badgeBg = CyanPrimary,
                        badgeTextColor = Color.White,
                        badgeText = if (type == QuestionType.MULTI) "已选" else null
                    )
                }
                else -> {
                    OptionStyle(
                        bgColor = MaterialTheme.colorScheme.surface,
                        borderColor = MaterialTheme.colorScheme.outlineVariant,
                        textColor = if (isRevealed) MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f) else MaterialTheme.colorScheme.onSurface,
                        circleBg = MaterialTheme.colorScheme.surfaceVariant,
                        circleTextColor = MaterialTheme.colorScheme.onSurfaceVariant,
                        badgeBg = Color.Transparent,
                        badgeTextColor = Color.Transparent,
                        badgeText = null
                    )
                }
            }

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(12.dp))
                    .background(style.bgColor)
                    .border(1.5.dp, style.borderColor, RoundedCornerShape(12.dp))
                    .clickable(enabled = !isRevealed || type == QuestionType.MULTI) {
                        onOptionClick(opt.key)
                    }
                    .padding(horizontal = 14.dp, vertical = 12.dp)
                    .testTag("option_${opt.key}")
            ) {
                // Key circle with option key letter
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .size(32.dp)
                        .clip(CircleShape)
                        .background(style.circleBg)
                ) {
                    Text(
                        text = opt.key,
                        fontWeight = FontWeight.Bold,
                        fontSize = 14.sp,
                        color = style.circleTextColor
                    )
                }

                Spacer(modifier = Modifier.width(12.dp))

                // Option Text - guaranteed high contrast and readable
                Text(
                    text = opt.text,
                    style = MaterialTheme.typography.bodyMedium,
                    fontSize = 15.sp,
                    lineHeight = 22.sp,
                    fontWeight = if (isSelected || (isRevealed && isCorrectOption)) FontWeight.SemiBold else FontWeight.Normal,
                    color = style.textColor,
                    modifier = Modifier.weight(1f)
                )

                // Optional status badge
                if (style.badgeText != null) {
                    Spacer(modifier = Modifier.width(8.dp))
                    Surface(
                        color = style.badgeBg,
                        shape = RoundedCornerShape(6.dp)
                    ) {
                        Text(
                            text = style.badgeText,
                            fontSize = 11.sp,
                            fontWeight = FontWeight.Bold,
                            color = style.badgeTextColor,
                            modifier = Modifier.padding(horizontal = 6.dp, vertical = 3.dp)
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun FillInTheBlankInput(
    responseDraft: String,
    recordedResponse: String,
    isRevealed: Boolean,
    onDraftChange: (String) -> Unit,
    onSubmit: () -> Unit
) {
    Column {
        if (!isRevealed) {
            OutlinedTextField(
                value = responseDraft,
                onValueChange = onDraftChange,
                placeholder = { Text("在此输入填空答案 (多个答案可用顿号隔开)...") },
                singleLine = true,
                shape = RoundedCornerShape(12.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = CyanAccent,
                    unfocusedBorderColor = MaterialTheme.colorScheme.outlineVariant
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .testTag("fill_input")
            )

            Spacer(modifier = Modifier.height(10.dp))

            Button(
                onClick = onSubmit,
                enabled = responseDraft.isNotBlank(),
                shape = RoundedCornerShape(10.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .testTag("submit_fill_button")
            ) {
                Text("提交答案", fontWeight = FontWeight.Bold)
            }
        } else {
            Surface(
                color = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f),
                shape = RoundedCornerShape(10.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "你的作答：${recordedResponse.ifBlank { "未填写" }}",
                    fontSize = 14.sp,
                    modifier = Modifier.padding(12.dp),
                    color = MaterialTheme.colorScheme.onSurface
                )
            }
        }
    }
}

@Composable
private fun ShortAnswerInput(
    responseDraft: String,
    recordedResponse: String,
    isRevealed: Boolean,
    onDraftChange: (String) -> Unit,
    onSubmit: () -> Unit
) {
    Column {
        if (!isRevealed) {
            OutlinedTextField(
                value = responseDraft,
                onValueChange = onDraftChange,
                placeholder = { Text("写下你的分析或答题要点，完成后对照标准答案自评...") },
                minLines = 3,
                maxLines = 6,
                shape = RoundedCornerShape(12.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = CyanAccent,
                    unfocusedBorderColor = MaterialTheme.colorScheme.outlineVariant
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .testTag("short_input")
            )

            Spacer(modifier = Modifier.height(10.dp))

            Button(
                onClick = onSubmit,
                shape = RoundedCornerShape(10.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .testTag("submit_short_button")
            ) {
                Text("完成作答 · 查看参考答案", fontWeight = FontWeight.Bold)
            }
        } else {
            Surface(
                color = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f),
                shape = RoundedCornerShape(10.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(modifier = Modifier.padding(12.dp)) {
                    Text(
                        text = "你的作答：",
                        fontSize = 13.sp,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = recordedResponse.ifBlank { "直接查看答案" },
                        fontSize = 14.sp,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                }
            }
        }
    }
}

@Composable
private fun ExplanationBox(
    item: QuestionWithProgress,
    quizMode: QuizMode,
    onSelfGrade: (Boolean) -> Unit
) {
    val q = item.question
    val isCorrect = item.isCorrect
    val isDark = isSystemInDarkTheme()

    Spacer(modifier = Modifier.height(16.dp))

    val containerBg = when {
        quizMode == QuizMode.MEMORIZE -> if (isDark) Color(0xFF132742) else Color(0xFFEFF6FF)
        isCorrect == true -> if (isDark) GreenCorrectDarkBg else Color(0xFFECFDF5)
        isCorrect == false -> if (isDark) RedWrongDarkBg else Color(0xFFFEF2F2)
        else -> if (isDark) AmberReviewDarkBg else Color(0xFFFFFBEB)
    }

    val cardBorder = when {
        quizMode == QuizMode.MEMORIZE -> CyanAccent.copy(alpha = 0.5f)
        isCorrect == true -> GreenCorrect.copy(alpha = 0.6f)
        isCorrect == false -> RedWrong.copy(alpha = 0.6f)
        else -> AmberReview.copy(alpha = 0.6f)
    }

    val titleColor = when {
        quizMode == QuizMode.MEMORIZE -> CyanAccent
        isCorrect == true -> GreenCorrect
        isCorrect == false -> RedWrong
        else -> AmberReview
    }

    val explanationTextColor = when {
        isDark -> Color(0xFFE2E8F0)
        isCorrect == true -> Color(0xFF064E3B)
        isCorrect == false -> Color(0xFF7F1D1D)
        else -> MaterialTheme.colorScheme.onSurface
    }

    Card(
        colors = CardDefaults.cardColors(containerColor = containerBg),
        border = BorderStroke(1.dp, cardBorder),
        shape = RoundedCornerShape(14.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = when {
                        quizMode == QuizMode.MEMORIZE -> "💡 考点速览"
                        isCorrect == true -> "✅ 回答正确"
                        isCorrect == false -> "❌ 需复习 · 已自动记入错题本"
                        else -> "📝 请对照参考答案自评"
                    },
                    fontWeight = FontWeight.Bold,
                    fontSize = 15.sp,
                    color = titleColor
                )

                Surface(
                    color = if (isDark) Color(0xFF0F172A) else Color.White,
                    shape = RoundedCornerShape(8.dp),
                    border = BorderStroke(1.dp, titleColor.copy(alpha = 0.6f))
                ) {
                    Text(
                        text = "参考答案：${q.answer.joinToString("、")}",
                        fontWeight = FontWeight.ExtraBold,
                        fontSize = 13.sp,
                        color = titleColor,
                        modifier = Modifier.padding(horizontal = 10.dp, vertical = 5.dp)
                    )
                }
            }

            if (q.explanation.isNotBlank()) {
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = "【解析与法规指引】",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold,
                    color = if (isDark) Color(0xFF94A3B8) else Color(0xFF475569)
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = q.explanation,
                    fontSize = 14.sp,
                    lineHeight = 22.sp,
                    color = explanationTextColor
                )
            }

            // Self-grading buttons for fill-in-the-blank or short answer questions
            if (quizMode != QuizMode.MEMORIZE && (q.type == QuestionType.FILL || q.type == QuestionType.SHORT) && item.isCorrect == null) {
                Spacer(modifier = Modifier.height(14.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    Button(
                        onClick = { onSelfGrade(true) },
                        colors = ButtonDefaults.buttonColors(containerColor = GreenCorrect),
                        shape = RoundedCornerShape(10.dp),
                        modifier = Modifier
                            .weight(1f)
                            .testTag("grade_correct_btn")
                    ) {
                        Text("我答对了 (+1分)", fontWeight = FontWeight.Bold)
                    }

                    OutlinedButton(
                        onClick = { onSelfGrade(false) },
                        colors = ButtonDefaults.outlinedButtonColors(contentColor = RedWrong),
                        border = androidx.compose.foundation.BorderStroke(1.dp, RedWrong),
                        shape = RoundedCornerShape(10.dp),
                        modifier = Modifier
                            .weight(1f)
                            .testTag("grade_wrong_btn")
                    ) {
                        Text("记入错题本", fontWeight = FontWeight.Bold)
                    }
                }
            }
        }
    }
}
