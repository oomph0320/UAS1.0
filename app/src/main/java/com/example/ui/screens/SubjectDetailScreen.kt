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
import androidx.compose.material.icons.filled.AutoAwesome
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Description
import androidx.compose.material.icons.filled.FolderOpen
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Radar
import androidx.compose.material.icons.filled.Sensors
import androidx.compose.material.icons.filled.Shield
import androidx.compose.material.icons.filled.UploadFile
import androidx.compose.material.icons.filled.Videocam
import androidx.compose.material.icons.filled.WifiTethering
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.model.QuestionType
import com.example.data.model.QuestionWithProgress
import com.example.data.model.SubjectInfo
import com.example.ui.components.ImportQuestionsModal
import com.example.ui.theme.CyanAccent
import com.example.ui.theme.CyanPrimary
import com.example.ui.theme.GreenCorrect

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SubjectDetailScreen(
    subject: SubjectInfo,
    allQuestions: List<QuestionWithProgress>,
    onBackClick: () -> Unit,
    onStartQuiz: (SubjectInfo, QuestionType?) -> Unit,
    onImportTextForSubject: (String, (Int) -> Unit) -> Unit
) {
    var showImportModal by remember { mutableStateOf(false) }

    val subjectQuestions = allQuestions.filter {
        it.question.topic.contains(subject.title) || it.question.topic == subject.title
    }

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
            // 1. Subject Header Banner
            item {
                Card(
                    shape = RoundedCornerShape(16.dp),
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                    elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(modifier = Modifier.padding(18.dp)) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
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
                            Column {
                                Surface(
                                    color = CyanPrimary.copy(alpha = 0.15f),
                                    shape = RoundedCornerShape(4.dp)
                                ) {
                                    Text(
                                        text = subject.categoryBadge,
                                        fontSize = 11.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = CyanPrimary,
                                        modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                                    )
                                }
                                Spacer(modifier = Modifier.height(4.dp))
                                Text(
                                    text = subject.title,
                                    fontSize = 17.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = MaterialTheme.colorScheme.onSurface
                                )
                            }
                        }

                        Spacer(modifier = Modifier.height(12.dp))

                        Text(
                            text = subject.description,
                            fontSize = 13.sp,
                            lineHeight = 19.sp,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )

                        Spacer(modifier = Modifier.height(12.dp))

                        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                            subject.tags.forEach { tag ->
                                Surface(
                                    color = MaterialTheme.colorScheme.surfaceVariant,
                                    shape = RoundedCornerShape(6.dp)
                                ) {
                                    Text(
                                        text = tag,
                                        fontSize = 11.sp,
                                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                                        modifier = Modifier.padding(horizontal = 8.dp, vertical = 3.dp)
                                    )
                                }
                            }
                        }
                    }
                }
            }

            // 2. Question Bank Status & Expansion Slot (核心拓展口)
            item {
                Card(
                    shape = RoundedCornerShape(16.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = if (subjectQuestions.isEmpty()) {
                            MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.45f)
                        } else {
                            GreenCorrect.copy(alpha = 0.1f)
                        }
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .border(
                            width = 1.dp,
                            color = if (subjectQuestions.isEmpty()) CyanPrimary.copy(alpha = 0.35f) else GreenCorrect.copy(alpha = 0.4f),
                            shape = RoundedCornerShape(16.dp)
                        )
                ) {
                    Column(modifier = Modifier.padding(18.dp)) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Icon(
                                    imageVector = if (subjectQuestions.isEmpty()) Icons.Default.Info else Icons.Default.CheckCircle,
                                    contentDescription = null,
                                    tint = if (subjectQuestions.isEmpty()) CyanPrimary else GreenCorrect,
                                    modifier = Modifier.size(20.dp)
                                )
                                Spacer(modifier = Modifier.width(8.dp))
                                Text(
                                    text = "本科目题库建设状态",
                                    fontSize = 15.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = MaterialTheme.colorScheme.onSurface
                                )
                            }

                            Surface(
                                color = if (subjectQuestions.isEmpty()) MaterialTheme.colorScheme.surfaceVariant else GreenCorrect,
                                shape = RoundedCornerShape(8.dp)
                            ) {
                                Text(
                                    text = if (subjectQuestions.isEmpty()) "当前 0 道 · 拓展口就绪" else "已收录 ${subjectQuestions.size} 道",
                                    color = if (subjectQuestions.isEmpty()) MaterialTheme.colorScheme.onSurfaceVariant else Color.White,
                                    fontSize = 11.sp,
                                    fontWeight = FontWeight.Bold,
                                    modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                                )
                            }
                        }

                        Spacer(modifier = Modifier.height(10.dp))

                        if (subjectQuestions.isEmpty()) {
                            Text(
                                text = "本科目目前尚未录入题目，系统已预留完整的题库拓展接口。后续需要补充题库时，您可以通过直接上传 Word (.docx) 文档或在对话框中发送文档由 AI 助手批量录入。",
                                fontSize = 12.sp,
                                lineHeight = 18.sp,
                                color = MaterialTheme.colorScheme.onSurface
                            )

                            Spacer(modifier = Modifier.height(14.dp))

                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.spacedBy(10.dp)
                            ) {
                                Button(
                                    onClick = { showImportModal = true },
                                    colors = ButtonDefaults.buttonColors(containerColor = CyanPrimary),
                                    shape = RoundedCornerShape(10.dp),
                                    modifier = Modifier.weight(1f)
                                ) {
                                    Icon(Icons.Default.UploadFile, contentDescription = null, modifier = Modifier.size(16.dp))
                                    Spacer(modifier = Modifier.width(6.dp))
                                    Text("导入本科目题库", fontSize = 13.sp, fontWeight = FontWeight.Bold)
                                }
                            }
                        } else {
                            Text(
                                text = "本科目已成功录入 ${subjectQuestions.size} 道试题，您可以立即开启本科目专属专项刷题或模拟考！",
                                fontSize = 12.sp,
                                color = MaterialTheme.colorScheme.onSurface
                            )

                            Spacer(modifier = Modifier.height(12.dp))

                            Button(
                                onClick = { onStartQuiz(subject, null) },
                                colors = ButtonDefaults.buttonColors(containerColor = GreenCorrect),
                                shape = RoundedCornerShape(10.dp),
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                Icon(Icons.Default.PlayArrow, contentDescription = null, modifier = Modifier.size(18.dp))
                                Spacer(modifier = Modifier.width(6.dp))
                                Text("开始本科目刷题 (${subjectQuestions.size} 题)", fontSize = 13.sp, fontWeight = FontWeight.Bold)
                            }
                        }
                    }
                }
            }

            // 3. Knowledge Syllabus & Core Topics (专业知识大纲体系)
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
                            text = "本科目后续补充题库将围绕以下核心考点维度展开出题与分类：",
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

            // 4. Word & Text Import Guidance Card
            item {
                Card(
                    shape = RoundedCornerShape(16.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.4f)
                    ),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(Icons.Default.Description, contentDescription = null, tint = CyanAccent, modifier = Modifier.size(18.dp))
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(
                                text = "题库后续补充方式指引",
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Bold,
                                color = MaterialTheme.colorScheme.onSurface
                            )
                        }

                        Spacer(modifier = Modifier.height(8.dp))

                        Text(
                            text = "• 方式一：在当前 AI Studio 网页对话中直接发送 Word (.docx) 文件，告知 AI 助手「补充至 ${subject.title}」，AI 会自动完成结构化归纳入库。\n• 方式二：点击上方「导入本科目题库」，选择本地 Word 文件或粘贴题目文本直接录入，题目将自动与本科目绑定。",
                            fontSize = 12.sp,
                            lineHeight = 18.sp,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                }
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
