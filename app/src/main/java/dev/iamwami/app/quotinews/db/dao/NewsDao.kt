package dev.iamwami.app.quotinews.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import dev.iamwami.app.quotinews.db.dao.entity.NewsTable
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow

@Dao
interface NewsDao {
    @Query("select * from NewsTable")
    fun getAllNews(): StateFlow<NewsTable>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertNews(news: NewsTable)
}