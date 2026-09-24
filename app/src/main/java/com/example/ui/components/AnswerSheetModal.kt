package com.example.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.model.QuestionWithProgress
import com.example.ui.theme.AmberReview
import com.example.ui.theme.AmberReviewBg
import com.example.ui.theme.AmberReviewDarkBg
import com.example.ui.theme.AmberReviewDarkText
import com.example.ui.theme.CyanAccent
import com.example.ui.theme.GreenCorrect
import com.example.ui.theme.GreenCorrectBg
import com.example.ui.theme.GreenCorrectDarkBg
import com.example.ui.theme.GreenCorrectDarkText
import com.example.ui.theme.Navy900
import com.example.ui.theme.RedWrong
import com.example.ui.theme.RedWrongBg
import com.example.ui.theme.RedWrongDarkBg
import com.example.ui.theme.RedWrongDarkText

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AnswerSheetModal(
    pool: List<QuestionWithProgress>,
    currentIndex: Int,
    onSelectIndex: (Int) -> Unit,
    onDismiss: () -> Unit
) {
    val sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)

    val correctCount = pool.count { it.isCorrect == true }
    val wrongCount = pool.count { it.isCorrect == false }
    val reviewCount = pool.count { it.isRevealed && it.isCorrect == null }
    val answeredCount = pool.count { it.isAnswered }

    ModalBottomSheet(
        onDismissRequest = onDismiss,
        sheetState = sheetState,
        containerColor = MaterialTheme.colorScheme.surface,
        modifier = Modifier.testTag("answer_sheet_modal")
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
                .padding(bottom = 32.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "答题卡进度",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onSurface
                )
                Text(
                    text = "$answeredCount / ${pool.size} 已作答",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }

            Spacer(modifier = Modifier.height(14.dp))

            // Legend indicators
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                LegendItem(color = GreenCorrect, label = "正确 ($correctCount)")
                LegendItem(color = RedWrong, label = "错误 ($wrongCount)")
                LegendItem(color = AmberReview, label = "自评/速看 ($reviewCount)")
                LegendItem(color = MaterialTheme.colorScheme.outlineVariant, label = "未答")
            }

            Spacer(modifier = Modifier.height(18.dp))

            LazyVerticalGrid(
                columns = GridCells.Adaptive(minSize = 46.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp)
            ) {
                itemsIndexed(pool) { idx, item ->
                    val isCurrent = idx == currentIndex
                    val isDark = isSystemInDarkTheme()
                    val (bgColor, textColor, borderColor) = when {
                        item.isCorrect == true -> Triple(
                            if (isDark) GreenCorrectDarkBg else GreenCorrectBg,
                            if (isDark) GreenCorrectDarkText else GreenCorrect,
                            GreenCorrect
                        )
                        item.isCorrect == false -> Triple(
                            if (isDark) RedWrongDarkBg else RedWrongBg,
                            if (isDark) RedWrongDarkText else RedWrong,
                            RedWrong
                        )
                        item.isRevealed -> Triple(
                            if (isDark) AmberReviewDarkBg else AmberReviewBg,
                            if (isDark) AmberReviewDarkText else AmberReview,
                            AmberReview
                        )
                        item.isAnswered -> Triple(
                            MaterialTheme.colorScheme.primaryContainer,
                            MaterialTheme.colorScheme.primary,
                            MaterialTheme.colorScheme.primary
                        )
                        else -> Triple(
                            MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f),
                            MaterialTheme.colorScheme.onSurfaceVariant,
                            Color.Transparent
                        )
                    }

                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier
                            .size(46.dp)
                            .clip(RoundedCornerShape(10.dp))
                            .background(bgColor)
                            .border(
                                width = if (isCurrent) 2.5.dp else 1.dp,
                                color = if (isCurrent) CyanAccent else borderColor,
                                shape = RoundedCornerShape(10.dp)
                            )
                            .clickable {
                                onSelectIndex(idx)
                                onDismiss()
                            }
                            .testTag("answer_cell_$idx")
                    ) {
                        Text(
                            text = "${idx + 1}",
                            fontWeight = if (isCurrent) FontWeight.ExtraBold else FontWeight.Medium,
                            fontSize = 15.sp,
                            color = if (isCurrent) MaterialTheme.colorScheme.primary else textColor
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun LegendItem(color: Color, label: String) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Box(
            modifier = Modifier
                .size(10.dp)
                .clip(CircleShape)
                .background(color)
        )
        Spacer(modifier = Modifier.width(5.dp))
        Text(
            text = label,
            fontSize = 11.sp,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
    }
}
