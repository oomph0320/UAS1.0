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
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.Assignment
import androidx.compose.material.icons.filled.AutoAwesome
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material.icons.filled.FolderOpen
import androidx.compose.material.icons.filled.MilitaryTech
import androidx.compose.material.icons.filled.Radar
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Sensors
import androidx.compose.material.icons.filled.Shield
import androidx.compose.material.icons.filled.UploadFile
import androidx.compose.material.icons.filled.Videocam
import androidx.compose.material.icons.filled.WarningAmber
import androidx.compose.material.icons.filled.WifiTethering
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
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
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.model.QuestionWithProgress
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
import com.example.ui.viewmodel.Screen

@Composable
fun ExpertHomeScreen(
    allQuestions: List<QuestionWithProgress>,
    onOpenSubject: (SubjectInfo) -> Unit,
    onNavigate: (Screen) -> Unit,
    onStartExam: () -> Unit,
    onImportText: (String, (Int) -> Unit) -> Unit,
    onReloadDefaultBank: (((Int) -> Unit) -> Unit)? = null
) {
    val totalCount = allQuestions.size
    val answeredCount = allQuestions.count { it.isAnswered }
    val correctCount = allQuestions.count { it.isCorrect == true }
    val wrongCount = allQuestions.count { it.isWrong }
    val favoriteCount = allQuestions.count { it.isFavorite }
    val accuracy = if (answeredCount > 0) ((correctCount.toFloat() / answeredCount) * 100).toInt() else 0

    var showImportModal by remember { mutableStateOf(false) }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .testTag("expert_home_screen"),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // 1. Hero Header
        item {
            ExpertHeroHeader(
                totalQuestions = totalCount,
                accuracy = accuracy,
                onSearchClick = { onNavigate(Screen.SEARCH) },
                onImportClick = { showImportModal = true }
            )
        }

        // 2. Primary Subject Section Header
        item {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "核心理论科目",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onBackground
                )
                Surface(
                    color = GreenCorrect.copy(alpha = 0.15f),
                    shape = RoundedCornerShape(6.dp)
                ) {
                    Text(
                        text = "已收录全量真题",
                        color = GreenCorrect,
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(horizontal = 8.dp, vertical = 3.dp)
                    )
                }
            }
        }

        // 3. Primary Subject Card: 无人机技术基础
        item {
            PrimarySubjectCard(
                subject = SubjectCatalog.PRIMARY_SUBJECT,
                questionCount = totalCount,
                answeredCount = answeredCount,
                onClick = { onOpenSubject(SubjectCatalog.PRIMARY_SUBJECT) }
            )
        }

        // 4. Quick Tools Row
        item {
            QuickToolsGrid(
                wrongCount = wrongCount,
                favoriteCount = favoriteCount,
                onNavigate = onNavigate,
                onStartExam = onStartExam
            )
        }

        // 5. Extension Subjects Section Header
        item {
            Column {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "探测反制与低空安防拓展目录",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onBackground
                    )
                    Surface(
                        color = CyanPrimary.copy(alpha = 0.15f),
                        shape = RoundedCornerShape(6.dp)
                    ) {
                        Text(
                            text = "拓展口已就绪",
                            color = CyanPrimary,
                            fontSize = 11.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(horizontal = 8.dp, vertical = 3.dp)
                        )
                    }
                }
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "包含低空反制、雷达、无线电、光电与电磁干扰学科体系，已开放题库拓展导入接口",
                    fontSize = 12.sp,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }

        // 6. 5 Extension Subject Cards
        items(SubjectCatalog.EXTENSION_SUBJECTS) { subject ->
            val subCount = allQuestions.count {
                it.question.topic.contains(subject.title) || it.question.topic == subject.title
            }
            ExtensionSubjectCard(
                subject = subject,
                questionCount = subCount,
                onClick = { onOpenSubject(subject) }
            )
        }

        // 7. Word & Document Import Entry Banner
        item {
            Card(
                shape = RoundedCornerShape(14.dp),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.5f)),
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
                            Text("为各学科补充题库", fontWeight = FontWeight.Bold, fontSize = 14.sp, color = MaterialTheme.colorScheme.onSurface)
                            Text("直接选本地 Word (.docx) 文件或对话框发送", fontSize = 11.sp, color = MaterialTheme.colorScheme.onSurfaceVariant)
                        }
                    }

                    Surface(
                        color = CyanPrimary,
                        shape = RoundedCornerShape(8.dp)
                    ) {
                        Text(
                            text = "导入题库",
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
private fun ExpertHeroHeader(
    totalQuestions: Int,
    accuracy: Int,
    onSearchClick: () -> Unit,
    onImportClick: () -> Unit
) {
    Card(
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(containerColor = Color.Transparent),
        modifier = Modifier
            .fillMaxWidth()
            .testTag("expert_hero_header")
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    Brush.verticalGradient(
                        colors = listOf(Navy900, Navy800)
                    )
                )
                .padding(20.dp)
        ) {
            Column {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Box(
                                contentAlignment = Alignment.Center,
                                modifier = Modifier
                                    .size(32.dp)
                                    .clip(CircleShape)
                                    .background(CyanPrimary)
                            ) {
                                Icon(
                                    imageVector = Icons.Default.MilitaryTech,
                                    contentDescription = null,
                                    tint = Color.White,
                                    modifier = Modifier.size(20.dp)
                                )
                            }
                            Spacer(modifier = Modifier.width(10.dp))
                            Text(
                                text = "无人机专家",
                                fontSize = 22.sp,
                                fontWeight = FontWeight.ExtraBold,
                                color = Color.White
                            )
                        }
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(
                            text = "无人系统核心技术 · 低空防御反制专业体系",
                            fontSize = 12.sp,
                            color = CyanAccent.copy(alpha = 0.9f)
                        )
                    }

                    Row {
                        IconButton(onClick = onSearchClick) {
                            Icon(Icons.Default.Search, contentDescription = "搜索题目", tint = Color.White)
                        }
                        IconButton(onClick = onImportClick) {
                            Icon(Icons.Default.UploadFile, contentDescription = "导入题库", tint = CyanAccent)
                        }
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                // Stats Banner Row
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(12.dp))
                        .background(Color.White.copy(alpha = 0.08f))
                        .padding(horizontal = 16.dp, vertical = 10.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column {
                        Text("系统题库总数", fontSize = 11.sp, color = Color.White.copy(alpha = 0.7f))
                        Text("$totalQuestions 道真题", fontSize = 15.sp, fontWeight = FontWeight.Bold, color = Color.White)
                    }
                    Box(modifier = Modifier.width(1.dp).height(24.dp).background(Color.White.copy(alpha = 0.15f)))
                    Column {
                        Text("学科目录覆盖", fontSize = 11.sp, color = Color.White.copy(alpha = 0.7f))
                        Text("6 大专业模块", fontSize = 15.sp, fontWeight = FontWeight.Bold, color = CyanAccent)
                    }
                    Box(modifier = Modifier.width(1.dp).height(24.dp).background(Color.White.copy(alpha = 0.15f)))
                    Column {
                        Text("当前综合正答率", fontSize = 11.sp, color = Color.White.copy(alpha = 0.7f))
                        Text("$accuracy%", fontSize = 15.sp, fontWeight = FontWeight.Bold, color = GreenCorrect)
                    }
                }
            }
        }
    }
}

@Composable
private fun PrimarySubjectCard(
    subject: SubjectInfo,
    questionCount: Int,
    answeredCount: Int,
    onClick: () -> Unit
) {
    Card(
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick)
            .border(
                width = 1.5.dp,
                brush = Brush.horizontalGradient(listOf(CyanPrimary, CyanAccent)),
                shape = RoundedCornerShape(16.dp)
            )
            .testTag("primary_subject_card")
    ) {
        Column(modifier = Modifier.padding(18.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.Top
            ) {
                Row(
                    modifier = Modifier.weight(1f),
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
                            imageVector = Icons.Default.Assignment,
                            contentDescription = null,
                            tint = Color.White,
                            modifier = Modifier.size(26.dp)
                        )
                    }
                    Spacer(modifier = Modifier.width(14.dp))
                    Column {
                        Text(
                            text = subject.title,
                            fontSize = 17.sp,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.onSurface
                        )
                        Spacer(modifier = Modifier.height(2.dp))
                        Text(
                            text = subject.subtitle,
                            fontSize = 12.sp,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                }

                Surface(
                    color = GreenCorrect.copy(alpha = 0.15f),
                    shape = RoundedCornerShape(8.dp)
                ) {
                    Text(
                        text = "$questionCount 题已入库",
                        color = GreenCorrect,
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = "收录目前所有真题试题：单选题、多选题、判断题、填空题与简答分析题全覆盖，支持全题型专项突破、背题速记与45分钟全真模拟考。",
                fontSize = 12.sp,
                lineHeight = 18.sp,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )

            Spacer(modifier = Modifier.height(14.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
                    subject.tags.take(3).forEach { tag ->
                        Surface(
                            color = MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.6f),
                            shape = RoundedCornerShape(6.dp)
                        ) {
                            Text(
                                text = tag,
                                fontSize = 11.sp,
                                color = CyanPrimary,
                                modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                            )
                        }
                    }
                }

                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = "进入刷题看板",
                        fontSize = 13.sp,
                        fontWeight = FontWeight.Bold,
                        color = CyanPrimary
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowForward,
                        contentDescription = null,
                        tint = CyanPrimary,
                        modifier = Modifier.size(16.dp)
                    )
                }
            }
        }
    }
}

@Composable
private fun ExtensionSubjectCard(
    subject: SubjectInfo,
    questionCount: Int,
    onClick: () -> Unit
) {
    val subjectIcon: ImageVector = when (subject.id) {
        "counter_uas_tech" -> Icons.Default.Shield
        "radar_detection" -> Icons.Default.Radar
        "radio_detection" -> Icons.Default.WifiTethering
        "optoelectronic_detection" -> Icons.Default.Videocam
        "electromagnetic_jamming" -> Icons.Default.Sensors
        else -> Icons.Default.FolderOpen
    }

    Card(
        shape = RoundedCornerShape(14.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        elevation = CardDefaults.cardElevation(defaultElevation = 1.dp),
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick)
            .testTag("extension_card_${subject.id}")
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.Top
            ) {
                Row(
                    modifier = Modifier.weight(1f),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier
                            .size(38.dp)
                            .clip(RoundedCornerShape(10.dp))
                            .background(MaterialTheme.colorScheme.primaryContainer)
                    ) {
                        Icon(
                            imageVector = subjectIcon,
                            contentDescription = null,
                            tint = CyanPrimary,
                            modifier = Modifier.size(22.dp)
                        )
                    }
                    Spacer(modifier = Modifier.width(12.dp))
                    Column {
                        Text(
                            text = subject.title,
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.onSurface
                        )
                        Spacer(modifier = Modifier.height(2.dp))
                        Text(
                            text = subject.subtitle,
                            fontSize = 11.sp,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                }

                Surface(
                    color = if (questionCount > 0) GreenCorrect.copy(alpha = 0.15f) else MaterialTheme.colorScheme.surfaceVariant,
                    shape = RoundedCornerShape(6.dp)
                ) {
                    Text(
                        text = if (questionCount > 0) "$questionCount 道试题" else "拓展口已就绪",
                        color = if (questionCount > 0) GreenCorrect else MaterialTheme.colorScheme.onSurfaceVariant,
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Medium,
                        modifier = Modifier.padding(horizontal = 7.dp, vertical = 3.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = subject.description,
                fontSize = 12.sp,
                lineHeight = 17.sp,
                maxLines = 2,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )

            Spacer(modifier = Modifier.height(10.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
                    subject.tags.take(3).forEach { tag ->
                        Surface(
                            color = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f),
                            shape = RoundedCornerShape(4.dp)
                        ) {
                            Text(
                                text = tag,
                                fontSize = 10.sp,
                                color = MaterialTheme.colorScheme.onSurfaceVariant,
                                modifier = Modifier.padding(horizontal = 5.dp, vertical = 2.dp)
                            )
                        }
                    }
                }

                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = "查看大纲与拓展口",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Medium,
                        color = CyanPrimary
                    )
                    Spacer(modifier = Modifier.width(3.dp))
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowForward,
                        contentDescription = null,
                        tint = CyanPrimary,
                        modifier = Modifier.size(14.dp)
                    )
                }
            }
        }
    }
}

@Composable
private fun QuickToolsGrid(
    wrongCount: Int,
    favoriteCount: Int,
    onNavigate: (Screen) -> Unit,
    onStartExam: () -> Unit
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        // 1. 全真模拟考
        Card(
            shape = RoundedCornerShape(12.dp),
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
            modifier = Modifier
                .weight(1f)
                .clickable { onStartExam() }
                .testTag("quick_exam_card")
        ) {
            Column(modifier = Modifier.padding(12.dp)) {
                Icon(Icons.Default.AutoAwesome, contentDescription = null, tint = CyanPrimary, modifier = Modifier.size(20.dp))
                Spacer(modifier = Modifier.height(6.dp))
                Text("全真模拟考", fontWeight = FontWeight.Bold, fontSize = 13.sp, color = MaterialTheme.colorScheme.onSurface)
                Text("45分钟机考仿真", fontSize = 11.sp, color = MaterialTheme.colorScheme.onSurfaceVariant)
            }
        }

        // 2. 错题集
        Card(
            shape = RoundedCornerShape(12.dp),
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
            modifier = Modifier
                .weight(1f)
                .clickable { onNavigate(Screen.WRONG_BOOK) }
                .testTag("quick_wrong_card")
        ) {
            Column(modifier = Modifier.padding(12.dp)) {
                Icon(Icons.Default.WarningAmber, contentDescription = null, tint = RedWrong, modifier = Modifier.size(20.dp))
                Spacer(modifier = Modifier.height(6.dp))
                Text("错题复习", fontWeight = FontWeight.Bold, fontSize = 13.sp, color = MaterialTheme.colorScheme.onSurface)
                Text("$wrongCount 道需复习", fontSize = 11.sp, color = MaterialTheme.colorScheme.onSurfaceVariant)
            }
        }

        // 3. 收藏夹
        Card(
            shape = RoundedCornerShape(12.dp),
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
            modifier = Modifier
                .weight(1f)
                .clickable { onNavigate(Screen.FAVORITES) }
                .testTag("quick_fav_card")
        ) {
            Column(modifier = Modifier.padding(12.dp)) {
                Icon(Icons.Default.Bookmark, contentDescription = null, tint = AmberReview, modifier = Modifier.size(20.dp))
                Spacer(modifier = Modifier.height(6.dp))
                Text("收藏笔记", fontWeight = FontWeight.Bold, fontSize = 13.sp, color = MaterialTheme.colorScheme.onSurface)
                Text("$favoriteCount 道已收藏", fontSize = 11.sp, color = MaterialTheme.colorScheme.onSurfaceVariant)
            }
        }
    }
}
