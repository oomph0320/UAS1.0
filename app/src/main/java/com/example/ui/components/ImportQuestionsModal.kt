package com.example.ui.components

import android.content.Context
import android.net.Uri
import android.provider.OpenableColumns
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AutoAwesome
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Description
import androidx.compose.material.icons.filled.FolderOpen
import androidx.compose.material.icons.filled.Send
import androidx.compose.material.icons.filled.UploadFile
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ui.theme.CyanAccent
import com.example.ui.theme.CyanPrimary
import com.example.ui.theme.GreenCorrect
import com.example.util.QuestionParser
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ImportQuestionsModal(
    onDismiss: () -> Unit,
    onImportText: (String, (Int) -> Unit) -> Unit,
    onReloadDefaultBank: (((Int) -> Unit) -> Unit)? = null
) {
    val sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)
    val context = LocalContext.current
    val coroutineScope = rememberCoroutineScope()

    var inputText by remember { mutableStateOf("") }
    var importResultCount by remember { mutableStateOf<Int?>(null) }
    var statusMessage by remember { mutableStateOf<String?>(null) }
    var isImporting by remember { mutableStateOf(false) }
    var selectedFileName by remember { mutableStateOf<String?>(null) }

    // System File Picker for docx / txt / doc files
    val filePickerLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) { uri: Uri? ->
        if (uri != null) {
            val fileName = queryDisplayName(context, uri) ?: "题库文档.docx"
            selectedFileName = fileName
            isImporting = true
            statusMessage = "正在读取「$fileName」并提取题目..."

            coroutineScope.launch(Dispatchers.IO) {
                try {
                    val extractedText = if (fileName.endsWith(".docx", ignoreCase = true)) {
                        context.contentResolver.openInputStream(uri)?.use { stream ->
                            QuestionParser.extractTextFromDocx(stream)
                        } ?: ""
                    } else {
                        // Read as text
                        context.contentResolver.openInputStream(uri)?.use { stream ->
                            stream.bufferedReader(Charsets.UTF_8).readText()
                        } ?: ""
                    }

                    withContext(Dispatchers.Main) {
                        if (extractedText.isNotBlank()) {
                            inputText = extractedText
                            onImportText(extractedText) { count ->
                                isImporting = false
                                importResultCount = count
                                statusMessage = if (count > 0) {
                                    "🎉 成功从「$fileName」智能识别并导入 $count 道试题！已自动按题型入库。"
                                } else {
                                    "已提取「$fileName」内容，但未识别出标准题型结构，内容已自动载入下方编辑框，您可核对后导入。"
                                }
                            }
                        } else {
                            isImporting = false
                            statusMessage = "读取文档内容为空或文件损坏，建议直接复制 Word 内容粘贴在下方导入。"
                        }
                    }
                } catch (e: Exception) {
                    withContext(Dispatchers.Main) {
                        isImporting = false
                        statusMessage = "解析文件遇到异常：${e.localizedMessage ?: "未知错误"}，建议直接复制文本粘贴导入。"
                    }
                }
            }
        }
    }

    val sampleTemplate = """1. 遥控器与无人机对频状态下，信号微弱的最优先处理措施是？
A. 增大油门爬升
B. 将天线平面朝向无人机方向
C. 立即关闭遥控器电源
D. 开启室内姿态模式
答案：B
解析：遥控器全向天线的侧面辐射信号最强，顶端为盲区，天线平面正对无人机可获得最佳信号增益。

2. 多旋翼无人机动力电池在存放时，最适宜的单体存放电压是？
A. 4.20V
B. 3.85V
C. 3.00V
D. 4.35V
答案：B
解析：锂聚合物电池长期存放最佳存储电压为 3.80V ~ 3.85V。"""

    ModalBottomSheet(
        onDismissRequest = onDismiss,
        sheetState = sheetState,
        containerColor = MaterialTheme.colorScheme.surface,
        modifier = Modifier.testTag("import_questions_modal")
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
                .padding(bottom = 32.dp)
                .verticalScroll(rememberScrollState())
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier
                            .size(38.dp)
                            .clip(RoundedCornerShape(10.dp))
                            .background(CyanPrimary)
                    ) {
                        Icon(
                            imageVector = Icons.Default.UploadFile,
                            contentDescription = null,
                            tint = Color.White,
                            modifier = Modifier.size(22.dp)
                        )
                    }
                    Spacer(modifier = Modifier.width(12.dp))
                    Column {
                        Text(
                            text = "添加题库 · Word文档与试题导入",
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.onSurface
                        )
                        Text(
                            text = "支持 .docx、.txt 本地文件及对话框直接上传",
                            fontSize = 12.sp,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Method 1: Local File Picker (Direct Word / Txt Upload in App)
            Card(
                shape = RoundedCornerShape(14.dp),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.5f)
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .border(
                        width = 1.dp,
                        color = CyanPrimary.copy(alpha = 0.35f),
                        shape = RoundedCornerShape(14.dp)
                    )
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Box(
                            contentAlignment = Alignment.Center,
                            modifier = Modifier
                                .size(28.dp)
                                .clip(RoundedCornerShape(6.dp))
                                .background(CyanPrimary)
                        ) {
                            Icon(
                                imageVector = Icons.Default.FolderOpen,
                                contentDescription = null,
                                tint = Color.White,
                                modifier = Modifier.size(18.dp)
                            )
                        }
                        Spacer(modifier = Modifier.width(10.dp))
                        Text(
                            text = "方式一：App内直接选择 Word (.docx) / 文本文件",
                            fontWeight = FontWeight.Bold,
                            fontSize = 14.sp,
                            color = CyanPrimary
                        )
                    }
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "点击下方按钮直接从手机/设备中选择您的 Word 题库（.docx）或文本文件（.txt）。App 内置极速解析引擎，会自动读取所有试题、识别题型并无缝导入本地题库！",
                        fontSize = 12.sp,
                        lineHeight = 18.sp,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                    Spacer(modifier = Modifier.height(12.dp))
                    Button(
                        onClick = {
                            // Launch system file picker for documents
                            filePickerLauncher.launch("*/*")
                        },
                        enabled = !isImporting,
                        colors = ButtonDefaults.buttonColors(containerColor = CyanPrimary),
                        shape = RoundedCornerShape(10.dp),
                        modifier = Modifier
                            .fillMaxWidth()
                            .testTag("pick_local_file_button")
                    ) {
                        if (isImporting) {
                            CircularProgressIndicator(
                                color = Color.White,
                                strokeWidth = 2.dp,
                                modifier = Modifier.size(16.dp)
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Text("正在解析文档中...", fontSize = 13.sp)
                        } else {
                            Icon(Icons.Default.UploadFile, contentDescription = null, modifier = Modifier.size(18.dp))
                            Spacer(modifier = Modifier.width(8.dp))
                            Text("📂 选择本地 Word (.docx) / 题库文件导入", fontSize = 13.sp, fontWeight = FontWeight.Bold)
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(12.dp))

            // Method 2: Upload via AI Studio Chat
            Card(
                shape = RoundedCornerShape(14.dp),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f)
                ),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(modifier = Modifier.padding(14.dp)) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            imageVector = Icons.Default.Send,
                            contentDescription = null,
                            tint = CyanAccent,
                            modifier = Modifier.size(18.dp)
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = "方式二：在 AI Studio 网页对话框直接发文件",
                            fontWeight = FontWeight.Bold,
                            fontSize = 13.sp,
                            color = MaterialTheme.colorScheme.onSurface
                        )
                    }
                    Spacer(modifier = Modifier.height(6.dp))
                    Text(
                        text = "您也可以在当前界面的聊天输入框，点击附件/上传图标将 Word 文件（.docx / .doc）发在对话中。AI 助手会自动解析所有单选、多选、判断、填空与综合分析题并更新入库。",
                        fontSize = 12.sp,
                        lineHeight = 18.sp,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }

            Spacer(modifier = Modifier.height(14.dp))

            // Method 3: Paste text
            Text(
                text = "方式三：复制题目文本直接粘贴导入",
                fontSize = 13.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onSurface
            )

            Spacer(modifier = Modifier.height(6.dp))

            Text(
                text = "若 Word 已打开，也可直接全选复制题目粘贴至下方，系统自动提取选项、答案与解析：",
                fontSize = 12.sp,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )

            Spacer(modifier = Modifier.height(8.dp))

            OutlinedTextField(
                value = inputText,
                onValueChange = {
                    inputText = it
                    importResultCount = null
                },
                placeholder = {
                    Text("请在此粘贴题目文本...\n例：\n1. 题目内容\nA. 选项A\nB. 选项B\n答案：A\n解析：考点说明...", fontSize = 12.sp)
                },
                minLines = 5,
                maxLines = 10,
                shape = RoundedCornerShape(12.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = CyanAccent,
                    unfocusedBorderColor = MaterialTheme.colorScheme.outlineVariant
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .testTag("import_text_field")
            )

            Spacer(modifier = Modifier.height(10.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                OutlinedButton(
                    onClick = {
                        inputText = sampleTemplate
                        importResultCount = null
                        statusMessage = null
                    },
                    shape = RoundedCornerShape(8.dp)
                ) {
                    Text("填入格式示例", fontSize = 12.sp)
                }

                Button(
                    onClick = {
                        if (inputText.isNotBlank()) {
                            isImporting = true
                            onImportText(inputText) { count ->
                                isImporting = false
                                importResultCount = count
                                statusMessage = if (count > 0) {
                                    "成功智能识别并导入 $count 道试题！"
                                } else {
                                    "未能识别出有效试题，请检查题目格式（题号、选项、答案）。"
                                }
                                if (count > 0) {
                                    inputText = ""
                                }
                            }
                        }
                    },
                    enabled = inputText.isNotBlank() && !isImporting,
                    colors = ButtonDefaults.buttonColors(containerColor = CyanPrimary),
                    shape = RoundedCornerShape(8.dp),
                    modifier = Modifier.testTag("confirm_import_button")
                ) {
                    Icon(Icons.Default.AutoAwesome, contentDescription = null, modifier = Modifier.size(16.dp))
                    Spacer(modifier = Modifier.width(6.dp))
                    Text(if (isImporting) "正在智能解析..." else "一键识别文本并导入", fontSize = 13.sp)
                }
            }

            if (statusMessage != null || importResultCount != null) {
                Spacer(modifier = Modifier.height(12.dp))
                val isSuccess = (importResultCount != null && importResultCount!! > 0) || (statusMessage?.contains("成功") == true)
                Surface(
                    color = if (isSuccess) MaterialTheme.colorScheme.primaryContainer else MaterialTheme.colorScheme.errorContainer,
                    shape = RoundedCornerShape(10.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Row(
                        modifier = Modifier.padding(12.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            imageVector = Icons.Default.CheckCircle,
                            contentDescription = null,
                            tint = if (isSuccess) GreenCorrect else MaterialTheme.colorScheme.error,
                            modifier = Modifier.size(18.dp)
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = statusMessage ?: if (importResultCount!! > 0) "成功导入 ${importResultCount} 道试题！" else "未能识别出题目，请检查格式。",
                            fontSize = 13.sp,
                            fontWeight = FontWeight.Bold,
                            color = if (isSuccess) CyanPrimary else MaterialTheme.colorScheme.error
                        )
                    }
                }
            }

            if (onReloadDefaultBank != null) {
                Spacer(modifier = Modifier.height(16.dp))
                OutlinedButton(
                    onClick = {
                        onReloadDefaultBank { totalCount ->
                            statusMessage = "大题库已同步至最新全量试题（共 $totalCount 道题，覆盖单选、多选、判断、填空、简答全题型）！"
                            importResultCount = null
                        }
                    },
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(10.dp)
                ) {
                    Icon(Icons.Default.UploadFile, contentDescription = null, modifier = Modifier.size(16.dp))
                    Spacer(modifier = Modifier.width(8.dp))
                    Text("同步 / 恢复最新完整大题库 (含2026/2025 CAAC及UOM全量真题)", fontSize = 12.sp)
                }
            }
        }
    }
}

private fun queryDisplayName(context: Context, uri: Uri): String? {
    var result: String? = null
    if (uri.scheme == "content") {
        try {
            context.contentResolver.query(uri, null, null, null, null)?.use { cursor ->
                if (cursor.moveToFirst()) {
                    val nameIndex = cursor.getColumnIndex(OpenableColumns.DISPLAY_NAME)
                    if (nameIndex != -1) {
                        result = cursor.getString(nameIndex)
                    }
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
    if (result == null) {
        result = uri.path?.substringAfterLast('/')
    }
    return result
}
