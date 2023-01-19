package dev.iamwami.app.quotinews.db

import android.content.Context
import android.graphics.Typeface.createFromAsset
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import dev.iamwami.app.quotinews.db.dao.NewsDao
import dev.iamwami.app.quotinews.db.dao.entity.NewsTable
import dev.iamwami.app.quotinews.model.News

@Database(entities = [NewsTable::class], version = 1)
abstract class AppDatabase():RoomDatabase(){
    abstract fun newsDao():NewsDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(
            context: Context
        ): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "app_database"
                )
                    .build()
                INSTANCE = instance

                instance
            }
        }
    }
}