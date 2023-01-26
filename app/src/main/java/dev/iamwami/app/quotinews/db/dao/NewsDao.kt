package dev.iamwami.app.quotinews.db.dao

import androidx.room.Dao
import androidx.room.Insert
import dev.iamwami.app.quotinews.db.entity.NewsTable

@Dao
interface NewsDao {
    @Insert()
    suspend fun insertNews(news: NewsTable)
}