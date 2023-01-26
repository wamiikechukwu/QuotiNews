package dev.iamwami.app.quotinews.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import dev.iamwami.app.quotinews.db.dao.NewsDao
import dev.iamwami.app.quotinews.db.entity.NewsTable
import dev.iamwami.app.quotinews.util.TypeConverter

@Database(entities = [NewsTable::class], version = 1)
@TypeConverters(TypeConverter::class)
abstract class AppDatabase() : RoomDatabase() {
    abstract fun newsDao(): NewsDao
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
                ).build()
                INSTANCE = instance

                instance
            }
        }
    }
}