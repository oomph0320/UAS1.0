package com.example.ui.screens

import androidx.compose.foundation.background
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SecondaryTabRow
import androidx.compose.material3.Surface
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.model.QuestionWithProgress
import com.example.ui.theme.AmberReview
import com.example.ui.theme.CyanAccent
import com.example.ui.theme.CyanPrimary

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FavoritesAndNotesScreen(
    allQuestions: List<QuestionWithProgress>,
    onBackClick: () -> Unit,
    onStartFavoritesQuiz: () -> Unit,
    onToggleFavorite: (String) -> Unit,
    onDeleteNote: (String) -> Unit
) {
    var selectedTab by remember { mutableIntStateOf(0) }
    val favorites = allQuestions.filter { it.isFavorite }
    val notes = allQuestions.filter { it.note.isNotBlank() }

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text("收藏与笔记", fontWeight = FontWeight.Bold) },
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "返回")
                    }
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.surface
                )
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .background(MaterialTheme.colorScheme.background)
        ) {
            SecondaryTabRow(
                selectedTabIndex = selectedTab,
                containerColor = MaterialTheme.colorScheme.surface
            ) {
                Tab(
                    selected = selectedTab == 0,
                    onClick = { selectedTab = 0 },
                    text = { Text("重点收藏 (${favorites.size})", fontWeight = FontWeight.Bold) }
                )
                Tab(
                    selected = selectedTab == 1,
                    onClick = { selectedTab = 1 },
                    text = { Text("我的笔记 (${notes.size})", fontWeight = FontWeight.Bold) }
                )
            }

            if (selectedTab == 0) {
                // Favorites Tab
                if (favorites.isNotEmpty()) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "已收藏 ${favorites.size} 道高频易忘题",
                            fontSize = 13.sp,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                        Button(
                            onClick = onStartFavoritesQuiz,
                            colors = ButtonDefaults.buttonColors(containerColor = CyanPrimary),
                            shape = RoundedCornerShape(10.dp)
                        ) {
                            Icon(Icons.Default.PlayArrow, contentDescription = null, modifier = Modifier.size(16.dp))
                            Spacer(modifier = Modifier.width(4.dp))
                            Text("练习收藏题", fontSize = 13.sp)
                        }
                    }
                }

                if (favorites.isEmpty()) {
                    EmptyStateNotice(icon = Icons.Default.Star, text = "暂无收藏题目", subtext = "在做题时点击右上角五角星即可加入收藏")
                } else {
                    LazyColumn(
                        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
                        verticalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        items(favorites, key = { it.question.id }) { item ->
                            FavoriteItemCard(item = item, onUnstar = { onToggleFavorite(item.question.id) })
                        }
                    }
                }
            } else {
                // Notes Tab
                if (notes.isEmpty()) {
                    EmptyStateNotice(icon = Icons.Default.Bookmark, text = "暂无题目笔记", subtext = "做题时点击笔记图标即可随时写下复习心得与口诀")
                } else {
                    LazyColumn(
                        contentPadding = PaddingValues(16.dp),
                        verticalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        items(notes, key = { it.question.id }) { item ->
                            NoteItemCard(item = item, onDeleteNote = { onDeleteNote(item.question.id) })
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun EmptyStateNotice(icon: androidx.compose.ui.graphics.vector.ImageVector, text: String, subtext: String) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize().padding(32.dp)
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Icon(icon, contentDescription = null, tint = CyanAccent, modifier = Modifier.size(56.dp))
            Spacer(modifier = Modifier.height(12.dp))
            Text(text, style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(4.dp))
            Text(subtext, fontSize = 12.sp, color = MaterialTheme.colorScheme.onSurfaceVariant)
        }
    }
}

@Composable
private fun FavoriteItemCard(item: QuestionWithProgress, onUnstar: () -> Unit) {
    val q = item.question
    Card(
        shape = RoundedCornerShape(14.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        modifier = Modifier.fillMaxWidth().testTag("fav_item_${q.id}")
    ) {
        Column(modifier = Modifier.padding(14.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Surface(
                    color = MaterialTheme.colorScheme.primaryContainer,
                    shape = RoundedCornerShape(6.dp)
                ) {
                    Text(
                        text = q.type.displayName,
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Bold,
                        color = CyanPrimary,
                        modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                    )
                }

                IconButton(onClick = onUnstar, modifier = Modifier.size(32.dp)) {
                    Icon(Icons.Default.Star, contentDescription = "取消收藏", tint = AmberReview)
                }
            }

            Spacer(modifier = Modifier.height(6.dp))
            Text(text = q.question, fontSize = 14.sp, fontWeight = FontWeight.Medium)
            Spacer(modifier = Modifier.height(6.dp))
            Text(
                text = "参考答案：${q.answer.joinToString("、")}",
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary
            )
        }
    }
}

@Composable
private fun NoteItemCard(item: QuestionWithProgress, onDeleteNote: () -> Unit) {
    val q = item.question
    Card(
        shape = RoundedCornerShape(14.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        modifier = Modifier.fillMaxWidth().testTag("note_item_${q.id}")
    ) {
        Column(modifier = Modifier.padding(14.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "${q.type.displayName} · ${q.topic}",
                    fontSize = 11.sp,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )

                IconButton(onClick = onDeleteNote, modifier = Modifier.size(32.dp)) {
                    Icon(Icons.Default.Delete, contentDescription = "删除笔记", tint = MaterialTheme.colorScheme.onSurfaceVariant)
                }
            }

            Spacer(modifier = Modifier.height(6.dp))
            Text(text = q.question, fontSize = 13.sp, color = MaterialTheme.colorScheme.onSurfaceVariant)

            Spacer(modifier = Modifier.height(10.dp))
            Surface(
                color = MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.4f),
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "📝 我的笔记：\n${item.note}",
                    fontSize = 13.sp,
                    lineHeight = 18.sp,
                    modifier = Modifier.padding(10.dp),
                    color = MaterialTheme.colorScheme.onSurface
                )
            }
        }
    }
}
