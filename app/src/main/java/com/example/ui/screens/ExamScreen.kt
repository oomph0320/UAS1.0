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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Alarm
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.GridView
import androidx.compose.material.icons.filled.Warning
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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
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
import com.example.ui.theme.Navy800
import com.example.ui.theme.RedWrong
import kotlinx.coroutines.delay

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ExamScreen(
    pool: List<QuestionWithProgress>,
    currentIndex: Int,
    selectedKeys: List<String>,
    textResponseDraft: String,
    onBackClick: () -> Unit,
    onOptionClick: (String) -> Unit,
    onSubmitMulti: () -> Unit,
    onTextDraftChange: (String) -> Unit,
    onSubmitFill: () -> Unit,
    onSubmitShort: () -> Unit,
    onSelfGrade: (Boolean) -> Unit,
    onJumpToQuestion: (Int) -> Unit,
    onNextQuestion: () -> Unit,
    onPrevQuestion: () -> Unit
) {
    if (pool.isEmpty()) {
        onBackClick()
        return
    }

    var remainingSeconds by remember { mutableIntStateOf(2700) } // 45 mins
    var isSubmitted by remember { mutableStateOf(false) }
    var showSubmitConfirmDialog by remember { mutableStateOf(false) }
    var showAnswerSheet by remember { mutableStateOf(false) }

    // Timer tick
    LaunchedEffect(isSubmitted) {
        while (!isSubmitted && remainingSeconds > 0) {
            delay(1000)
            remainingSeconds -= 1
        }
        if (remainingSeconds <= 0 && !isSubmitted) {
            isSubmitted = true
        }
    }

    val currentItem = pool.getOrElse(currentIndex) { pool.first() }
    val answeredCount = pool.count { it.isAnswered }
    val correctCount = pool.count { it.isCorrect == true }
    val score = if (pool.isNotEmpty()) (correctCount.toFloat() / pool.size * 100).toInt() else 0
    val isPassed = score >= 80

    val minutes = remainingSeconds / 60
    val seconds = remainingSeconds % 60
    val timeFormatted = String.format("%02d:%02d", minutes, seconds)

    if (isSubmitted) {
        // Exam Result Report Screen
        Scaffold(
            topBar = {
                CenterAlignedTopAppBar(
                    title = { Text("模拟考试成绩单", fontWeight = FontWeight.Bold) },
                    navigationIcon = {
                        IconButton(onClick = onBackClick) {
                            Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "返回")
                        }
                    }
                )
            }
        ) { innerPadding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
                    .padding(20.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .size(110.dp)
                        .clip(CircleShape)
                        .background(if (isPassed) GreenCorrect.copy(alpha = 0.15f) else RedWrong.copy(alpha = 0.15f))
                ) {
                    Icon(
                        imageVector = if (isPassed) Icons.Default.CheckCircle else Icons.Default.Warning,
                        contentDescription = null,
                        tint = if (isPassed) GreenCorrect else RedWrong,
                        modifier = Modifier.size(60.dp)
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = if (isPassed) "考核通过 (合格)" else "未达到合格标准",
                    style = MaterialTheme.typography.headlineSmall,
                    fontWeight = FontWeight.ExtraBold,
                    color = if (isPassed) GreenCorrect else RedWrong
                )

                Spacer(modifier = Modifier.height(6.dp))

                Text(
                    text = "得分：$score 分 (及格线：80分)",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onSurface
                )

                Spacer(modifier = Modifier.height(20.dp))

                Card(
                    shape = RoundedCornerShape(16.dp),
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(modifier = Modifier.padding(18.dp)) {
                        Text("• 总试题数：${pool.size} 道")
                        Spacer(modifier = Modifier.height(6.dp))
                        Text("• 正确道数：$correctCount 道", color = GreenCorrect, fontWeight = FontWeight.Bold)
                        Spacer(modifier = Modifier.height(6.dp))
                        Text("• 错误道数：${pool.size - correctCount} 道", color = RedWrong, fontWeight = FontWeight.Bold)
                        Spacer(modifier = Modifier.height(6.dp))
                        Text("• 剩余考试时间：$timeFormatted")
                    }
                }

                Spacer(modifier = Modifier.height(28.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    OutlinedButton(
                        onClick = { isSubmitted = false },
                        shape = RoundedCornerShape(12.dp),
                        modifier = Modifier.weight(1f).height(48.dp)
                    ) {
                        Text("核对试题与解析")
                    }

                    Button(
                        onClick = onBackClick,
                        colors = ButtonDefaults.buttonColors(containerColor = CyanPrimary),
                        shape = RoundedCornerShape(12.dp),
                        modifier = Modifier.weight(1f).height(48.dp)
                    ) {
                        Text("返回首页", fontWeight = FontWeight.Bold)
                    }
                }
            }
        }
        return
    }

    // Active Exam View
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Text("全真模拟考试", style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Bold)
                        Text(
                            text = "${currentIndex + 1} / ${pool.size} 题",
                            fontSize = 12.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = CyanPrimary
                        )
                    }
                },
                navigationIcon = {
                    IconButton(onClick = { showSubmitConfirmDialog = true }) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "退出考试")
                    }
                },
                actions = {
                    // Timer pill
                    Surface(
                        color = Navy800,
                        shape = RoundedCornerShape(14.dp),
                        modifier = Modifier.padding(end = 8.dp)
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                        ) {
                            Icon(Icons.Default.Alarm, contentDescription = null, tint = CyanAccent, modifier = Modifier.size(14.dp))
                            Spacer(modifier = Modifier.width(4.dp))
                            Text(timeFormatted, fontSize = 12.sp, fontWeight = FontWeight.Bold, color = Color.White)
                        }
                    }

                    IconButton(onClick = { showAnswerSheet = true }) {
                        Icon(Icons.Default.GridView, contentDescription = "答题卡")
                    }
                }
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
                        modifier = Modifier.weight(1f).height(48.dp)
                    ) {
                        Text("上一题")
                    }

                    Button(
                        onClick = { showSubmitConfirmDialog = true },
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFD97706)),
                        shape = RoundedCornerShape(12.dp),
                        modifier = Modifier.weight(1f).height(48.dp)
                    ) {
                        Text("交卷结算", fontWeight = FontWeight.Bold)
                    }

                    Button(
                        onClick = onNextQuestion,
                        enabled = currentIndex < pool.size - 1,
                        shape = RoundedCornerShape(12.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = CyanPrimary),
                        modifier = Modifier.weight(1f).height(48.dp)
                    ) {
                        Text("下一题 →")
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
            LinearProgressIndicator(
                progress = { (currentIndex + 1).toFloat() / pool.size },
                color = CyanAccent,
                trackColor = MaterialTheme.colorScheme.surfaceVariant,
                modifier = Modifier.fillMaxWidth().height(3.dp)
            )

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
                    .padding(16.dp)
            ) {
                QuestionCard(
                    item = currentItem,
                    quizMode = QuizMode.PRACTICE,
                    selectedKeys = selectedKeys,
                    textResponseDraft = textResponseDraft,
                    onOptionClick = onOptionClick,
                    onSubmitMulti = onSubmitMulti,
                    onTextDraftChange = onTextDraftChange,
                    onSubmitFill = onSubmitFill,
                    onSubmitShort = onSubmitShort,
                    onSelfGrade = onSelfGrade,
                    onRevealAnswer = { /* Exam hides answer peek */ },
                    onToggleFavorite = {},
                    onSaveNote = {}
                )
            }
        }
    }

    if (showAnswerSheet) {
        AnswerSheetModal(
            pool = pool,
            currentIndex = currentIndex,
            onSelectIndex = onJumpToQuestion,
            onDismiss = { showAnswerSheet = false }
        )
    }

    if (showSubmitConfirmDialog) {
        AlertDialog(
            onDismissRequest = { showSubmitConfirmDialog = false },
            title = { Text("确认交卷？", fontWeight = FontWeight.Bold) },
            text = {
                Text("本次考试共有 ${pool.size} 题，您已完成 $answeredCount 题。交卷后将生成考试成绩单。")
            },
            confirmButton = {
                Button(
                    onClick = {
                        showSubmitConfirmDialog = false
                        isSubmitted = true
                    }
                ) {
                    Text("确认交卷")
                }
            },
            dismissButton = {
                TextButton(onClick = { showSubmitConfirmDialog = false }) {
                    Text("继续答题")
                }
            }
        )
    }
}
