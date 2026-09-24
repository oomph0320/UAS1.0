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
import androidx.compose.material.icons.filled.Assignment
import androidx.compose.material.icons.filled.AutoAwesome
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.MenuBook
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Speed
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.Timer
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material.icons.outlined.CheckCircleOutline
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.material.icons.filled.UploadFile
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
import com.example.ui.components.ImportQuestionsModal
import com.example.ui.theme.AmberReview
import com.example.ui.theme.CyanAccent
import com.example.ui.theme.CyanPrimary
import com.example.ui.theme.GreenCorrect
import com.example.ui.theme.Navy800
import com.example.ui.theme.Navy900
import com.example.ui.theme.RedWrong
import com.example.ui.viewmodel.Screen

@Composable
fun HomeScreen(
    allQuestions: List<QuestionWithProgress>,
    quizMode: QuizMode,
    isRandomOrder: Boolean,
    onSetQuizMode: (QuizMode) -> Unit,
    onSetRandomOrder: (Boolean) -> Unit,
    onStartQuizByType: (QuestionType?) -> Unit,
    onNavigate: (Screen) -> Unit,
    onStartExam: () -> Unit,
    onImportText: (String, (Int) -> Unit) -> Unit,
    onReloadDefaultBank: (((Int) -> Unit) -> Unit)? = null,
    onBackToExpertHome: (() -> Unit)? = null
) {
    val totalCount = allQuestions.size
    val answeredCount = allQuestions.count { it.isAnswered }
    val correctCount = allQuestions.count { it.isCorrect == true }
    val wrongCount = allQuestions.count { it.isWrong }
    val favoriteCount = allQuestions.count { it.isFavorite }
    val notesCount = allQuestions.count { it.note.isNotBlank() }
    val accuracy = if (answeredCount > 0) ((correctCount.toFloat() / answeredCount) * 100).toInt() else 0

    var showImportModal by remember { mutableStateOf(false) }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .testTag("home_screen"),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // Hero Header
        item {
            HeroHeaderCard(
                totalCount = totalCount,
                answeredCount = answeredCount,
                accuracy = accuracy,
                wrongCount = wrongCount,
                onSearchClick = { onNavigate(Screen.SEARCH) },
                onImportClick = { showImportModal = true },
                onBackToExpertHome = onBackToExpertHome
            )
        }

        // Mode and Order Settings Bar
        item {
            ModeSettingsCard(
                quizMode = quizMode,
                isRandomOrder = isRandomOrder,
                onSetQuizMode = onSetQuizMode,
                onSetRandomOrder = onSetRandomOrder
            )
        }

        // Section Title: 题型分类刷题 (User requirement: 只按题型进行分类)
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
                Text(
                    text = "大题库直通",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = CyanAccent
                )
            }
        }

        // 1. 全部大题库综合模式
        item {
            TypeCategoryCard(
                title = "全部题型 · 综合练习",
                subtitle = "覆盖法规、气动原理、电池、飞控及应急全考点",
                type = null,
                icon = Icons.Default.MenuBook,
                iconColor = CyanPrimary,
                allQuestions = allQuestions,
                onClick = { onStartQuizByType(null) }
            )
        }

        // 2. 单选题库
        item {
            TypeCategoryCard(
                title = "单选题",
                subtitle = "核心客观理论题 · 四选一精准评测",
                type = QuestionType.SINGLE,
                icon = Icons.Default.CheckCircle,
                iconColor = Color(0xFF0284C7),
                allQuestions = allQuestions,
                onClick = { onStartQuizByType(QuestionType.SINGLE) }
            )
        }

        // 3. 多选题库
        item {
            TypeCategoryCard(
                title = "多选题",
                subtitle = "综合考点排查 · 漏选多选严格判题",
                type = QuestionType.MULTI,
                icon = Icons.Default.Assignment,
                iconColor = Color(0xFF7C3AED),
                allQuestions = allQuestions,
                onClick = { onStartQuizByType(QuestionType.MULTI) }
            )
        }

        // 4. 判断题库
        item {
            TypeCategoryCard(
                title = "判断题",
                subtitle = "真伪概念快速辨析 · 强化记忆盲区",
                type = QuestionType.JUDGE,
                icon = Icons.Outlined.CheckCircleOutline,
                iconColor = Color(0xFF0D9488),
                allQuestions = allQuestions,
                onClick = { onStartQuizByType(QuestionType.JUDGE) }
            )
        }

        // 5. 填空题库
        item {
            TypeCategoryCard(
                title = "填空题",
                subtitle = "关键数值与术语 · 自动校验及辅助自评",
                type = QuestionType.FILL,
                icon = Icons.Default.Edit,
                iconColor = Color(0xFFD97706),
                allQuestions = allQuestions,
                onClick = { onStartQuizByType(QuestionType.FILL) }
            )
        }

        // 6. 简答题库
        item {
            TypeCategoryCard(
                title = "简答与综合分析题",
                subtitle = "应急处置与飞行原理要点论述 · 专家标准答案",
                type = QuestionType.SHORT,
                icon = Icons.Default.AutoAwesome,
                iconColor = Color(0xFFE11D48),
                allQuestions = allQuestions,
                onClick = { onStartQuizByType(QuestionType.SHORT) }
            )
        }

        // Section Title: 专项突破与复习工具
        item {
            Text(
                text = "专项突破与考前巩固",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onBackground
            )
        }

        // Quick feature grid
        item {
            QuickToolsRow(
                wrongCount = wrongCount,
                favoriteCount = favoriteCount,
                notesCount = notesCount,
                onNavigate = onNavigate,
                onStartExam = onStartExam
            )
        }

        // Upload and Supplement Bank Card
        item {
            Card(
                shape = RoundedCornerShape(14.dp),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.45f)),
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { showImportModal = true }
                    .testTag("import_banner_card")
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(14.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(
                        modifier = Modifier.weight(1f),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Box(
                            contentAlignment = Alignment.Center,
                            modifier = Modifier
                                .size(40.dp)
                                .clip(RoundedCornerShape(10.dp))
                                .background(CyanPrimary)
                        ) {
                            Icon(Icons.Default.UploadFile, contentDescription = null, tint = Color.White, modifier = Modifier.size(22.dp))
                        }
                        Spacer(modifier = Modifier.width(12.dp))
                        Column {
                            Text("补充题库 & 导入试题", fontWeight = FontWeight.Bold, fontSize = 14.sp, color = MaterialTheme.colorScheme.onSurface)
                            Text("支持选择本地Word(.docx)文件或对话框发送", fontSize = 11.sp, color = MaterialTheme.colorScheme.onSurfaceVariant)
                        }
                    }

                    Surface(
                        color = CyanPrimary,
                        shape = RoundedCornerShape(8.dp)
                    ) {
                        Text(
                            text = "导入",
                            color = Color.White,
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp)
                        )
                    }
                }
            }
        }

        item {
            Spacer(modifier = Modifier.height(16.dp))
        }
    }

    if (showImportModal) {
        ImportQuestionsModal(
            onDismiss = { showImportModal = false },
            onImportText = onImportText,
            onReloadDefaultBank = onReloadDefaultBank
        )
    }
}

@Composable
private fun HeroHeaderCard(
    totalCount: Int,
    answeredCount: Int,
    accuracy: Int,
    wrongCount: Int,
    onSearchClick: () -> Unit,
    onImportClick: () -> Unit,
    onBackToExpertHome: (() -> Unit)? = null
) {
    Card(
        shape = RoundedCornerShape(22.dp),
        colors = CardDefaults.cardColors(containerColor = Navy800),
        modifier = Modifier.fillMaxWidth()
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    Brush.linearGradient(
                        colors = listOf(Navy900, Color(0xFF13365E))
                    )
                )
                .padding(20.dp)
        ) {
            Column {
                if (onBackToExpertHome != null) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .clip(RoundedCornerShape(8.dp))
                            .clickable { onBackToExpertHome() }
                            .padding(bottom = 12.dp)
                    ) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "返回无人机专家",
                            tint = CyanAccent,
                            modifier = Modifier.size(18.dp)
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(
                            text = "返回无人机专家",
                            color = CyanAccent,
                            fontSize = 13.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column(modifier = Modifier.weight(1f)) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(
                                imageVector = Icons.Default.Speed,
                                contentDescription = null,
                                tint = CyanAccent,
                                modifier = Modifier.size(18.dp)
                            )
                            Spacer(modifier = Modifier.width(6.dp))
                            Text(
                                text = "核心理论科目 · 执照真题全量收录",
                                fontSize = 11.sp,
                                fontWeight = FontWeight.Bold,
                                color = CyanAccent,
                                letterSpacing = 1.sp
                            )
                        }

                        Spacer(modifier = Modifier.height(6.dp))

                        Text(
                            text = "无人机技术基础",
                            fontSize = 24.sp,
                            fontWeight = FontWeight.ExtraBold,
                            color = Color.White
                        )
                    }

                    Row(verticalAlignment = Alignment.CenterVertically) {
                        IconButton(
                            onClick = onImportClick,
                            modifier = Modifier
                                .size(40.dp)
                                .clip(CircleShape)
                                .background(CyanAccent.copy(alpha = 0.2f))
                                .testTag("home_import_btn")
                        ) {
                            Icon(
                                imageVector = Icons.Default.UploadFile,
                                contentDescription = "补充题库",
                                tint = CyanAccent
                            )
                        }

                        Spacer(modifier = Modifier.width(8.dp))

                        IconButton(
                            onClick = onSearchClick,
                            modifier = Modifier
                                .size(40.dp)
                                .clip(CircleShape)
                                .background(Color.White.copy(alpha = 0.12f))
                                .testTag("home_search_btn")
                        ) {
                            Icon(
                                imageVector = Icons.Default.Search,
                                contentDescription = "搜索题库",
                                tint = Color.White
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.height(18.dp))

                // Stats row
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    StatBox(label = "总题量", value = "$totalCount", unit = "题")
                    StatBox(label = "已完成", value = "$answeredCount", unit = "题")
                    StatBox(label = "正确率", value = "$accuracy", unit = "%")
                    StatBox(label = "错题量", value = "$wrongCount", unit = "道", highlightColor = RedWrong)
                }
            }
        }
    }
}

@Composable
private fun StatBox(
    label: String,
    value: String,
    unit: String,
    highlightColor: Color = Color.White
) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Row(verticalAlignment = Alignment.Bottom) {
            Text(
                text = value,
                fontSize = 22.sp,
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
            fontSize = 12.sp,
            color = Color.White.copy(alpha = 0.75f)
        )
    }
}

@Composable
private fun ModeSettingsCard(
    quizMode: QuizMode,
    isRandomOrder: Boolean,
    onSetQuizMode: (QuizMode) -> Unit,
    onSetRandomOrder: (Boolean) -> Unit
) {
    Card(
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        elevation = CardDefaults.cardElevation(defaultElevation = 1.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            // Mode toggle
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
                    modifier = Modifier.testTag("mode_switch")
                )
            }

            Spacer(modifier = Modifier.height(12.dp))

            // Random toggle
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
                        text = if (isRandomOrder) "打乱题目顺序，提升实战应变能力" else "按题库固定顺序逐题复习",
                        fontSize = 12.sp,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }

                Switch(
                    checked = isRandomOrder,
                    onCheckedChange = onSetRandomOrder,
                    colors = SwitchDefaults.colors(checkedThumbColor = CyanAccent),
                    modifier = Modifier.testTag("random_switch")
                )
            }
        }
    }
}

@Composable
private fun TypeCategoryCard(
    title: String,
    subtitle: String,
    type: QuestionType?,
    icon: ImageVector,
    iconColor: Color,
    allQuestions: List<QuestionWithProgress>,
    onClick: () -> Unit
) {
    val questions = if (type == null) allQuestions else allQuestions.filter { it.question.type == type }
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
                    .size(48.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .background(iconColor.copy(alpha = 0.12f))
            ) {
                Icon(
                    imageVector = icon,
                    contentDescription = null,
                    tint = iconColor,
                    modifier = Modifier.size(26.dp)
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

                    if (answered > 0) {
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = "正答 $accuracy%",
                            fontSize = 11.sp,
                            color = GreenCorrect,
                            fontWeight = FontWeight.SemiBold
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun QuickToolsRow(
    wrongCount: Int,
    favoriteCount: Int,
    notesCount: Int,
    onNavigate: (Screen) -> Unit,
    onStartExam: () -> Unit
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        QuickToolCard(
            title = "错题本",
            count = "$wrongCount 题",
            icon = Icons.Default.Warning,
            color = RedWrong,
            modifier = Modifier.weight(1f),
            onClick = { onNavigate(Screen.WRONG_BOOK) }
        )

        QuickToolCard(
            title = "模拟考试",
            count = "45分钟",
            icon = Icons.Default.Timer,
            color = CyanAccent,
            modifier = Modifier.weight(1f),
            onClick = onStartExam
        )

        QuickToolCard(
            title = "收藏与笔记",
            count = "$favoriteCount 藏 / $notesCount 记",
            icon = Icons.Default.Star,
            color = AmberReview,
            modifier = Modifier.weight(1f),
            onClick = { onNavigate(Screen.FAVORITES) }
        )
    }
}

@Composable
private fun QuickToolCard(
    title: String,
    count: String,
    icon: ImageVector,
    color: Color,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Surface(
        color = MaterialTheme.colorScheme.surface,
        shape = RoundedCornerShape(14.dp),
        border = androidx.compose.foundation.BorderStroke(1.dp, MaterialTheme.colorScheme.outlineVariant),
        modifier = modifier
            .clickable { onClick() }
            .testTag("quick_tool_${title}")
    ) {
        Column(
            modifier = Modifier.padding(12.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .size(36.dp)
                    .clip(CircleShape)
                    .background(color.copy(alpha = 0.15f))
            ) {
                Icon(icon, contentDescription = null, tint = color, modifier = Modifier.size(20.dp))
            }

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = title,
                fontSize = 13.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onSurface
            )

            Text(
                text = count,
                fontSize = 11.sp,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}
