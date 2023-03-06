package dev.iamwami.app.quotinews.util

import java.time.LocalDate
import java.time.format.DateTimeFormatter


fun dateFormatter(date: String): String {
    val oldDate = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'")
    return LocalDate.parse(date, oldDate).toString()
}