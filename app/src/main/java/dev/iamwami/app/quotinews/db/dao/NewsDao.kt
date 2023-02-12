package dev.iamwami.app.quotinews.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import dev.iamwami.app.quotinews.db.entity.NewsTable
import dev.iamwami.app.quotinews.model.News
import kotlinx.coroutines.flow.Flow

@Dao
interface NewsDao {
    @Insert()
    suspend fun insertNews(news: List<NewsTable>)

    @Query("SELECT * FROM NewsTable")
    fun fetchAllNews() : Flow<List<NewsTable>>

}