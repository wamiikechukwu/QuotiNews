package dev.iamwami.app.quotinews.util

import androidx.room.TypeConverter
import com.google.gson.Gson

import dev.iamwami.app.quotinews.db.entity.Source


class TypeConverter {
    @TypeConverter
    fun fromSourceToString(value: Source): String {
        return Gson().toJson(value)
    }

    @TypeConverter
    fun toSourceFromString(value: String): Source {
        return Gson().fromJson(value, Source::class.java)
    }
}