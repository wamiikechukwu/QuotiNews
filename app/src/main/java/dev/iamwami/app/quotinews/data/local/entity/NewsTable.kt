package dev.iamwami.app.quotinews.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity()
data class NewsTable(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val source: Source,
    val urlToImage: String?,
    val title: String?,
    val author: String?,
    val description: String?,
    val url: String?,
    val publishedAt: String?,
    val content: String?
)

data class Source(
    val id: String?,
    val name: String?
)


