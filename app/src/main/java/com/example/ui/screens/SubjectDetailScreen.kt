package com.example.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.Assignment
import androidx.compose.material.icons.filled.AutoAwesome
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Description
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.FolderOpen
import androidx.compose.material.icons.filled.MenuBook
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Radar
import androidx.compose.material.icons.filled.Sensors
import androidx.compose.material.icons.filled.Shield
import androidx.compose.material.icons.filled.UploadFile
import androidx.compose.material.icons.filled.Videocam
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material.icons.filled.WifiTethering
import androidx.compose.material.icons.outlined.CheckCircleOutline
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.model.QuestionType
import com.example.data.model.QuestionWithProgress
import com.example.data.model.QuizMode
import com.example.data.model.SubjectCatalog
import com.example.data.model.SubjectInfo
import com.example.ui.components.ImportQuestionsModal
import com.example.ui.theme.AmberReview
import com.example.ui.theme.CyanAccent
import com.example.ui.theme.CyanPrimary
import com.example.ui.theme.GreenCorrect
import com.example.ui.theme.Navy800
import com.example.ui.theme.Navy900
import com.example.ui.theme.RedWrong

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SubjectDetailScreen(
    subject: SubjectInfo,
    allQuestions: List<QuestionWithProgress>,
    quizMode: QuizMode,
    isRandomOrder: Boolean,
    onSetQuizMode: (QuizMode) -> Unit,
    onSetRandomOrder: (Boolean) -> Unit,
    onBackClick: () -> Unit,
    onStartQuiz: (SubjectInfo, QuestionType?) -> Unit,
    onStartWrongQuiz: ((SubjectInfo) -> Unit)? = null,
    onImportTextForSubject: (String, (Int) -> Unit) -> Unit
) {
    var showImportModal by remember { mutableStateOf(false) }

    // Filter questions belonging to this subject
    val subjectQuestions = allQuestions.filter {
        if (subject.isPrimary) {
            it.question.topic.contains(subject.title) ||
            SubjectCatalog.EXTENSION_SUBJECTS.none { ext -> it.question.topic.contains(ext.title) }
        } else {
            it.question.topic.contains(subject.title) || it.question.topic == subject.title
        }
    }

    val totalCount = subjectQuestions.size
    val answeredCount = subjectQuestions.count { it.isAnswered }
    val correctCount = subjectQuestions.count { it.isCorrect == true }
    val wrongCount = subjectQuestions.count { it.isWrong }
    val accuracy = if (answeredCount > 0) ((correctCount.toFloat() / answeredCount) * 100).toInt() else 0

    val subjectIcon: ImageVector = when (subject.id) {
        "counter_uas_tech" -> Icons.Default.Shield
        "radar_detection" -> Icons.Default.Radar
        "radio_detection" -> Icons.Default.WifiTethering
        "optoelectronic_detection" -> Icons.Default.Videocam
        "electromagnetic_jamming" -> Icons.Default.Sensors
        else -> Icons.Default.FolderOpen
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = subject.title,
                        maxLines = 1,
                        fontSize = 17.sp,
                        fontWeight = FontWeight.Bold
                    )
                },
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "返回无人机专家")
                    }
                },
                actions = {
                    IconButton(onClick = { showImportModal = true }) {
                        Icon(Icons.Default.UploadFile, contentDescription = "导入本科目题库", tint = CyanPrimary)
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.surface
                )
            )
        },
        modifier = Modifier.testTag("subject_detail_screen")
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // 1. Subject Header Banner with Stats
            item {
                Card(
                    shape = RoundedCornerShape(20.dp),
                    colors = CardDefaults.cardColors(containerColor = Color.Transparent),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(
                                Brush.verticalGradient(
                                    colors = listOf(Navy900, Navy800)
                                )
                            )
                            .padding(18.dp)
                    ) {
                        Column {
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Box(
                                    contentAlignment = Alignment.Center,
                                    modifier = Modifier
                                        .size(46.dp)
                                        .clip(RoundedCornerShape(12.dp))
                                        .background(CyanPrimary)
                                ) {
                                    Icon(
                                        imageVector = subjectIcon,
                                        contentDescription = null,
                                        tint = Color.White,
                                        modifier = Modifier.size(26.dp)
                                    )
                                }
                                Spacer(modifier = Modifier.width(14.dp))
                                Column(modifier = Modifier.weight(1f)) {
                                    Surface(
                                        color = CyanAccent.copy(alpha = 0.2f),
                                        shape = RoundedCornerShape(4.dp)
                                    ) {
                                        Text(
                                            text = subject.categoryBadge,
                                            fontSize = 11.sp,
                                            fontWeight = FontWeight.Bold,
                                            color = CyanAccent,
                                            modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                                        )
                                    }
                                    Spacer(modifier = Modifier.height(4.dp))
                                    Text(
                                        text = subject.title,
                                        fontSize = 17.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = Color.White
                                    )
                                    Text(
                                        text = subject.subtitle,
                                        fontSize = 11.sp,
                                        color = Color.White.copy(alpha = 0.75f)
                                    )
                                }
                            }

                            Spacer(modifier = Modifier.height(12.dp))

                            Text(
                                text = subject.description,
                                fontSize = 12.sp,
                                lineHeight = 18.sp,
                                color = Color.White.copy(alpha = 0.85f)
                            )

                            Spacer(modifier = Modifier.height(14.dp))

                            // Stats Grid inside header
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                SubjectStatBox(label = "题库总量", value = "$totalCount", unit = "道")
                                SubjectStatBox(label = "已完成", value = "$answeredCount", unit = "道")
                                SubjectStatBox(label = "答题正确率", value = "$accuracy", unit = "%")
                                SubjectStatBox(label = "错题记录", value = "$wrongCount", unit = "道", highlightColor = if (wrongCount > 0) RedWrong else Color.White)
                            }
                        }
                    }
                }
            }

            // 2. Mode and Order Settings Card
            item {
                Card(
                    shape = RoundedCornerShape(16.dp),
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                    elevation = CardDefaults.cardElevation(defaultElevation = 1.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Column(modifier = Modifier.weight(1f)) {
                                Text(
                                    text = if (quizMode == QuizMode.PRACTICE) "刷题练习模式 (常规判题)" else "背题速记模式 (直显答案)",
                                    fontSize = 14.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = MaterialTheme.colorScheme.onSurface
                                )
                                Text(
                                    text = if (quizMode == QuizMode.PRACTICE) "作答后立即批改与解析，适合自测模拟" else "直接展示标准答案与考点，适合考前快速过题",
                                    fontSize = 12.sp,
                                    color = MaterialTheme.colorScheme.onSurfaceVariant
                                )
                            }
                            Switch(
                                checked = quizMode == QuizMode.MEMORIZE,
                                onCheckedChange = { isMemorize ->
                                    onSetQuizMode(if (isMemorize) QuizMode.MEMORIZE else QuizMode.PRACTICE)
                                },
                                colors = SwitchDefaults.colors(checkedThumbColor = CyanAccent),
                                modifier = Modifier.testTag("subject_mode_switch")
                            )
                        }

                        Spacer(modifier = Modifier.height(10.dp))

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Column(modifier = Modifier.weight(1f)) {
                                Text(
                                    text = if (isRandomOrder) "题目顺序：随机乱序" else "题目顺序：原题顺序",
                                    fontSize = 14.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = MaterialTheme.colorScheme.onSurface
                                )
                                Text(
                                    text = if (isRandomOrder) "打乱题目顺序，提升实战应变能力" else "按学科题库编排固定顺序逐题复习",
                                    fontSize = 12.sp,
                                    color = MaterialTheme.colorScheme.onSurfaceVariant
                                )
                            }
                            Switch(
                                checked = isRandomOrder,
                                onCheckedChange = onSetRandomOrder,
                                colors = SwitchDefaults.colors(checkedThumbColor = CyanAccent),
                                modifier = Modifier.testTag("subject_random_switch")
                            )
                        }
                    }
                }
            }

            // 3. Question Type Classification Section Header
            item {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "题型分类专练",
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onBackground
                    )
                    Surface(
                        color = CyanPrimary.copy(alpha = 0.12f),
                        shape = RoundedCornerShape(6.dp)
                    ) {
                        Text(
                            text = "本科目按题型定向突破",
                            fontSize = 11.sp,
                            fontWeight = FontWeight.Bold,
                            color = CyanPrimary,
                            modifier = Modifier.padding(horizontal = 8.dp, vertical = 3.dp)
                        )
                    }
                }
            }

            // 4. 全部题型 · 综合练习
            item {
                SubjectTypeCard(
                    title = "全部题型 · 综合练习",
                    subtitle = "覆盖${subject.title}全部核心理论、计算与实战应用",
                    type = null,
                    icon = Icons.Default.MenuBook,
                    iconColor = CyanPrimary,
                    questions = subjectQuestions,
                    onClick = { onStartQuiz(subject, null) }
                )
            }

            // 5. 单选题库
            item {
                SubjectTypeCard(
                    title = "单选题",
                    subtitle = "核心客观考点 · 精准单项指标与原理辨析",
                    type = QuestionType.SINGLE,
                    icon = Icons.Default.CheckCircle,
                    iconColor = Color(0xFF0284C7),
                    questions = subjectQuestions.filter { it.question.type == QuestionType.SINGLE },
                    onClick = { onStartQuiz(subject, QuestionType.SINGLE) }
                )
            }

            // 6. 多选题库
            item {
                SubjectTypeCard(
                    title = "多选题",
                    subtitle = "多维技术特征排查 · 漏选多选严格判卷",
                    type = QuestionType.MULTI,
                    icon = Icons.Default.Assignment,
                    iconColor = Color(0xFF7C3AED),
                    questions = subjectQuestions.filter { it.question.type == QuestionType.MULTI },
                    onClick = { onStartQuiz(subject, QuestionType.MULTI) }
                )
            }

            // 7. 判断题库
            item {
                SubjectTypeCard(
                    title = "判断题",
                    subtitle = "真伪技术参数与标准快速辨析 · 消除盲区",
                    type = QuestionType.JUDGE,
                    icon = Icons.Outlined.CheckCircleOutline,
                    iconColor = Color(0xFF0D9488),
                    questions = subjectQuestions.filter { it.question.type == QuestionType.JUDGE },
                    onClick = { onStartQuiz(subject, QuestionType.JUDGE) }
                )
            }

            // 8. 填空题库
            item {
                SubjectTypeCard(
                    title = "填空题",
                    subtitle = "关键数值参数、频段、协议与物理术语填空",
                    type = QuestionType.FILL,
                    icon = Icons.Default.Edit,
                    iconColor = Color(0xFFD97706),
                    questions = subjectQuestions.filter { it.question.type == QuestionType.FILL },
                    onClick = { onStartQuiz(subject, QuestionType.FILL) }
                )
            }

            // 9. 简答与综合分析题库
            item {
                SubjectTypeCard(
                    title = "简答与综合分析题",
                    subtitle = "实战部署处置、链路攻防与方案论述 · 专家标准答案",
                    type = QuestionType.SHORT,
                    icon = Icons.Default.AutoAwesome,
                    iconColor = Color(0xFFE11D48),
                    questions = subjectQuestions.filter { it.question.type == QuestionType.SHORT },
                    onClick = { onStartQuiz(subject, QuestionType.SHORT) }
                )
            }

            // 10. 本科目错题专项 (如果存在错题)
            if (wrongCount > 0 && onStartWrongQuiz != null) {
                item {
                    Card(
                        shape = RoundedCornerShape(14.dp),
                        colors = CardDefaults.cardColors(containerColor = RedWrong.copy(alpha = 0.08f)),
                        modifier = Modifier
                            .fillMaxWidth()
                            .border(1.dp, RedWrong.copy(alpha = 0.3f), RoundedCornerShape(14.dp))
                            .clickable { onStartWrongQuiz(subject) }
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(16.dp),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Box(
                                    contentAlignment = Alignment.Center,
                                    modifier = Modifier
                                        .size(40.dp)
                                        .clip(CircleShape)
                                        .background(RedWrong.copy(alpha = 0.15f))
                                ) {
                                    Icon(Icons.Default.Warning, contentDescription = null, tint = RedWrong, modifier = Modifier.size(20.dp))
                                }
                                Spacer(modifier = Modifier.width(12.dp))
                                Column {
                                    Text(
                                        text = "本科目错题专项强化",
                                        fontSize = 14.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = RedWrong
                                    )
                                    Text(
                                        text = "集中重练本科目做错的 $wrongCount 道试题，消灭薄弱点",
                                        fontSize = 11.sp,
                                        color = MaterialTheme.colorScheme.onSurfaceVariant
                                    )
                                }
                            }

                            Icon(Icons.AutoMirrored.Filled.ArrowForward, contentDescription = null, tint = RedWrong, modifier = Modifier.size(18.dp))
                        }
                    }
                }
            }

            // 11. Knowledge Syllabus & Core Topics
            item {
                Card(
                    shape = RoundedCornerShape(16.dp),
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(modifier = Modifier.padding(18.dp)) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(Icons.Default.AutoAwesome, contentDescription = null, tint = CyanPrimary, modifier = Modifier.size(18.dp))
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(
                                text = "专业知识大纲与核心考点体系",
                                fontSize = 15.sp,
                                fontWeight = FontWeight.Bold,
                                color = MaterialTheme.colorScheme.onSurface
                            )
                        }

                        Spacer(modifier = Modifier.height(6.dp))

                        Text(
                            text = "本科目题库严格围绕以下考点体系编排，支持在各题型中综合考核：",
                            fontSize = 12.sp,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )

                        Spacer(modifier = Modifier.height(14.dp))

                        subject.keyTopics.forEachIndexed { index, topic ->
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(vertical = 5.dp),
                                verticalAlignment = Alignment.Top
                            ) {
                                Box(
                                    contentAlignment = Alignment.Center,
                                    modifier = Modifier
                                        .size(20.dp)
                                        .clip(CircleShape)
                                        .background(CyanPrimary.copy(alpha = 0.15f))
                                ) {
                                    Text(
                                        text = "${index + 1}",
                                        fontSize = 11.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = CyanPrimary
                                    )
                                }
                                Spacer(modifier = Modifier.width(10.dp))
                                Text(
                                    text = topic,
                                    fontSize = 13.sp,
                                    lineHeight = 18.sp,
                                    color = MaterialTheme.colorScheme.onSurface
                                )
                            }
                        }
                    }
                }
            }

            // 12. Word & Text Import Guidance Card
            item {
                Card(
                    shape = RoundedCornerShape(16.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.4f)
                    ),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Icon(Icons.Default.Description, contentDescription = null, tint = CyanAccent, modifier = Modifier.size(18.dp))
                                Spacer(modifier = Modifier.width(8.dp))
                                Text(
                                    text = "本科目题库拓展与导入",
                                    fontSize = 14.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = MaterialTheme.colorScheme.onSurface
                                )
                            }

                            Button(
                                onClick = { showImportModal = true },
                                colors = ButtonDefaults.buttonColors(containerColor = CyanPrimary),
                                shape = RoundedCornerShape(8.dp),
                                contentPadding = PaddingValues(horizontal = 10.dp, vertical = 4.dp)
                            ) {
                                Icon(Icons.Default.UploadFile, contentDescription = null, modifier = Modifier.size(14.dp))
                                Spacer(modifier = Modifier.width(4.dp))
                                Text("导入题目", fontSize = 12.sp, fontWeight = FontWeight.Bold)
                            }
                        }

                        Spacer(modifier = Modifier.height(8.dp))

                        Text(
                            text = "• 方式一：在当前对话框中直接发送 Word (.docx) 文件，告知助手「补充至 ${subject.title}」，题目自动完成结构化归类。\n• 方式二：点击右上方「导入题目」，粘贴题例文本即可自动解析收录。",
                            fontSize = 12.sp,
                            lineHeight = 18.sp,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                }
            }

            item {
                Spacer(modifier = Modifier.height(16.dp))
            }
        }
    }

    if (showImportModal) {
        ImportQuestionsModal(
            onDismiss = { showImportModal = false },
            onImportText = { text, callback ->
                onImportTextForSubject(text, callback)
            }
        )
    }
}

@Composable
private fun SubjectStatBox(
    label: String,
    value: String,
    unit: String,
    highlightColor: Color = Color.White
) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Row(verticalAlignment = Alignment.Bottom) {
            Text(
                text = value,
                fontSize = 20.sp,
                fontWeight = FontWeight.ExtraBold,
                color = highlightColor
            )
            Text(
                text = unit,
                fontSize = 11.sp,
                color = Color.White.copy(alpha = 0.7f),
                modifier = Modifier.padding(bottom = 2.dp, start = 2.dp)
            )
        }
        Text(
            text = label,
            fontSize = 11.sp,
            color = Color.White.copy(alpha = 0.75f)
        )
    }
}

@Composable
private fun SubjectTypeCard(
    title: String,
    subtitle: String,
    type: QuestionType?,
    icon: ImageVector,
    iconColor: Color,
    questions: List<QuestionWithProgress>,
    onClick: () -> Unit
) {
    val total = questions.size
    val answered = questions.count { it.isAnswered }
    val correct = questions.count { it.isCorrect == true }
    val accuracy = if (answered > 0) ((correct.toFloat() / answered) * 100).toInt() else 0
    val progressFraction = if (total > 0) answered.toFloat() / total else 0f

    Card(
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        elevation = CardDefaults.cardElevation(defaultElevation = 1.dp),
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() }
            .testTag("type_card_${type?.code ?: "all"}")
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Icon
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .size(46.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .background(iconColor.copy(alpha = 0.12f))
            ) {
                Icon(
                    imageVector = icon,
                    contentDescription = null,
                    tint = iconColor,
                    modifier = Modifier.size(24.dp)
                )
            }

            Spacer(modifier = Modifier.width(14.dp))

            Column(modifier = Modifier.weight(1f)) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = title,
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                    Text(
                        text = "$answered / $total 题",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold,
                        color = CyanPrimary
                    )
                }

                Spacer(modifier = Modifier.height(3.dp))

                Text(
                    text = subtitle,
                    fontSize = 12.sp,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    maxLines = 1
                )

                Spacer(modifier = Modifier.height(8.dp))

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    LinearProgressIndicator(
                        progress = { progressFraction },
                        color = iconColor,
                        trackColor = MaterialTheme.colorScheme.surfaceVariant,
                        modifier = Modifier
                            .weight(1f)
                            .height(6.dp)
                            .clip(RoundedCornerShape(99.dp))
                    )

                    Spacer(modifier = Modifier.width(10.dp))

                    Text(
                        text = if (answered > 0) "正确率 $accuracy%" else "未开始",
                        fontSize = 11.sp,
                        color = if (answered > 0) GreenCorrect else MaterialTheme.colorScheme.onSurfaceVariant,
                        fontWeight = FontWeight.Medium
                    )
                }
            }

            Spacer(modifier = Modifier.width(8.dp))

            Icon(
                imageVector = Icons.AutoMirrored.Filled.ArrowForward,
                contentDescription = null,
                tint = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.6f),
                modifier = Modifier.size(16.dp)
            )
        }
    }
}
