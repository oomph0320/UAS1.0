package com.example.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface QuestionDao {
    @Query("SELECT * FROM questions ORDER BY rowid ASC")
    fun getAllQuestions(): Flow<List<QuestionEntity>>

    @Query("SELECT * FROM questions WHERE type = :type ORDER BY rowid ASC")
    fun getQuestionsByType(type: String): Flow<List<QuestionEntity>>

    @Query("SELECT * FROM questions WHERE question LIKE '%' || :query || '%' OR topic LIKE '%' || :query || '%' OR explanation LIKE '%' || :query || '%'")
    fun searchQuestions(query: String): Flow<List<QuestionEntity>>

    @Query("SELECT COUNT(*) FROM questions")
    suspend fun getQuestionCount(): Int

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(questions: List<QuestionEntity>)

    @Query("SELECT * FROM user_progress")
    fun getAllProgress(): Flow<List<UserQuestionProgressEntity>>

    @Query("SELECT * FROM user_progress WHERE questionId = :questionId")
    fun getProgress(questionId: String): Flow<UserQuestionProgressEntity?>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsertProgress(progress: UserQuestionProgressEntity)

    @Query("UPDATE user_progress SET isFavorite = :isFavorite, updatedAt = :time WHERE questionId = :questionId")
    suspend fun setFavorite(questionId: String, isFavorite: Boolean, time: Long = System.currentTimeMillis())

    @Query("UPDATE user_progress SET note = :note, updatedAt = :time WHERE questionId = :questionId")
    suspend fun setNote(questionId: String, note: String, time: Long = System.currentTimeMillis())

    @Query("UPDATE user_progress SET isWrong = 0, updatedAt = :time WHERE questionId = :questionId")
    suspend fun removeWrong(questionId: String, time: Long = System.currentTimeMillis())

    @Query("UPDATE user_progress SET isWrong = 0, updatedAt = :time")
    suspend fun clearAllWrongs(time: Long = System.currentTimeMillis())

    @Query("DELETE FROM user_progress")
    suspend fun resetAllProgress()
}
