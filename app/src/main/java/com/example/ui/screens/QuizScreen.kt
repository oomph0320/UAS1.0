package com.example.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.GridView
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBarDefaults
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
import com.example.data.model.QuestionWithProgress
import com.example.data.model.QuizMode
import com.example.ui.components.AnswerSheetModal
import com.example.ui.components.QuestionCard
import com.example.ui.theme.CyanAccent
import com.example.ui.theme.CyanPrimary
import com.example.ui.theme.GreenCorrect
import com.example.ui.theme.RedWrong

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun QuizScreen(
    title: String,
    pool: List<QuestionWithProgress>,
    currentIndex: Int,
    quizMode: QuizMode,
    selectedKeys: List<String>,
    textResponseDraft: String,
    onBackClick: () -> Unit,
    onOptionClick: (String) -> Unit,
    onSubmitMulti: () -> Unit,
    onTextDraftChange: (String) -> Unit,
    onSubmitFill: () -> Unit,
    onSubmitShort: () -> Unit,
    onSelfGrade: (Boolean) -> Unit,
    onRevealAnswer: () -> Unit,
    onToggleFavorite: (String) -> Unit,
    onSaveNote: (String, String) -> Unit,
    onJumpToQuestion: (Int) -> Unit,
    onNextQuestion: () -> Unit,
    onPrevQuestion: () -> Unit
) {
    if (pool.isEmpty()) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxSize().padding(24.dp)
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text("暂无题目", style = MaterialTheme.typography.titleLarge)
                Spacer(modifier = Modifier.height(12.dp))
                Button(onClick = onBackClick) {
                    Text("返回首页")
                }
            }
        }
        return
    }

    val currentItem = pool.getOrElse(currentIndex) { pool.first() }
    var showAnswerSheet by remember { mutableStateOf(false) }
    var showFinishDialog by remember { mutableStateOf(false) }

    val answeredCount = pool.count { it.isAnswered }
    val correctCount = pool.count { it.isCorrect == true }
    val wrongCount = pool.count { it.isCorrect == false }
    val progressFraction = (currentIndex + 1).toFloat() / pool.size

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Text(
                            text = title,
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold,
                            maxLines = 1
                        )
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Text(
                                text = "${currentIndex + 1} / ${pool.size}",
                                fontSize = 12.sp,
                                fontWeight = FontWeight.SemiBold,
                                color = CyanPrimary
                            )
                            Spacer(modifier = Modifier.width(6.dp))
                            Surface(
                                color = if (quizMode == QuizMode.MEMORIZE) MaterialTheme.colorScheme.primaryContainer else MaterialTheme.colorScheme.surfaceVariant,
                                shape = RoundedCornerShape(4.dp)
                            ) {
                                Text(
                                    text = if (quizMode == QuizMode.MEMORIZE) "背题模式" else "刷题模式",
                                    fontSize = 10.sp,
                                    color = if (quizMode == QuizMode.MEMORIZE) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurfaceVariant,
                                    modifier = Modifier.padding(horizontal = 4.dp, vertical = 2.dp)
                                )
                            }
                        }
                    }
                },
                navigationIcon = {
                    IconButton(onClick = onBackClick, modifier = Modifier.testTag("quiz_back_btn")) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "返回")
                    }
                },
                actions = {
                    IconButton(
                        onClick = { showAnswerSheet = true },
                        modifier = Modifier.testTag("quiz_answer_sheet_btn")
                    ) {
                        Icon(Icons.Default.GridView, contentDescription = "答题卡")
                    }
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.surface
                )
            )
        },
        bottomBar = {
            Surface(
                color = MaterialTheme.colorScheme.surface,
                shadowElevation = 8.dp,
                modifier = Modifier.fillMaxWidth()
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 12.dp),
                    horizontalArrangement = Arrangement.spacedBy(10.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    OutlinedButton(
                        onClick = onPrevQuestion,
                        enabled = currentIndex > 0,
                        shape = RoundedCornerShape(12.dp),
                        modifier = Modifier
                            .weight(1f)
                            .height(48.dp)
                            .testTag("prev_question_btn")
                    ) {
                        Text("上一题")
                    }

                    OutlinedButton(
                        onClick = { showAnswerSheet = true },
                        shape = RoundedCornerShape(12.dp),
                        modifier = Modifier
                            .weight(1f)
                            .height(48.dp)
                            .testTag("bottom_answer_sheet_btn")
                    ) {
                        Text("答题卡")
                    }

                    Button(
                        onClick = {
                            if (currentIndex == pool.size - 1) {
                                showFinishDialog = true
                            } else {
                                onNextQuestion()
                            }
                        },
                        shape = RoundedCornerShape(12.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = CyanPrimary),
                        modifier = Modifier
                            .weight(1.3f)
                            .height(48.dp)
                            .testTag("next_question_btn")
                    ) {
                        Text(
                            text = if (currentIndex == pool.size - 1) "完成练习" else "下一题 →",
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .background(MaterialTheme.colorScheme.background)
        ) {
            // Top Progress Indicator
            LinearProgressIndicator(
                progress = { progressFraction },
                color = CyanAccent,
                trackColor = MaterialTheme.colorScheme.surfaceVariant,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(3.dp)
            )

            // Scrollable question area
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
                    .padding(16.dp)
            ) {
                QuestionCard(
                    item = currentItem,
                    quizMode = quizMode,
                    selectedKeys = selectedKeys,
                    textResponseDraft = textResponseDraft,
                    onOptionClick = onOptionClick,
                    onSubmitMulti = onSubmitMulti,
                    onTextDraftChange = onTextDraftChange,
                    onSubmitFill = onSubmitFill,
                    onSubmitShort = onSubmitShort,
                    onSelfGrade = onSelfGrade,
                    onRevealAnswer = onRevealAnswer,
                    onToggleFavorite = { onToggleFavorite(currentItem.question.id) },
                    onSaveNote = { note -> onSaveNote(currentItem.question.id, note) }
                )

                Spacer(modifier = Modifier.height(32.dp))
            }
        }
    }

    // Modal Answer Sheet
    if (showAnswerSheet) {
        AnswerSheetModal(
            pool = pool,
            currentIndex = currentIndex,
            onSelectIndex = onJumpToQuestion,
            onDismiss = { showAnswerSheet = false }
        )
    }

    // Finish Dialog
    if (showFinishDialog) {
        AlertDialog(
            onDismissRequest = { showFinishDialog = false },
            title = {
                Text("本次练习结算", fontWeight = FontWeight.Bold)
            },
            text = {
                Column {
                    Text("恭喜完成本次刷题！数据统计如下：")
                    Spacer(modifier = Modifier.height(12.dp))
                    Card(
                        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant),
                        shape = RoundedCornerShape(12.dp)
                    ) {
                        Column(modifier = Modifier.padding(14.dp)) {
                            Text("• 练习总数：${pool.size} 道题")
                            Text("• 已作答数：$answeredCount 道题")
                            Text("• 答题正确：$correctCount 道题", color = GreenCorrect, fontWeight = FontWeight.Bold)
                            Text("• 答题错误：$wrongCount 道题", color = RedWrong, fontWeight = FontWeight.Bold)
                        }
                    }
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        "所有错题已自动收入「错题本」，可随时进行针对性复习。",
                        fontSize = 12.sp,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            },
            confirmButton = {
                Button(
                    onClick = {
                        showFinishDialog = false
                        onBackClick()
                    }
                ) {
                    Text("返回首页")
                }
            },
            dismissButton = {
                TextButton(onClick = { showFinishDialog = false }) {
                    Text("继续查看")
                }
            }
        )
    }
}
