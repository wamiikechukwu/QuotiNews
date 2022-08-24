package dev.iamwami.app.quotinews.util

import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import dev.iamwami.app.quotinews.R

object Fonts {
    val syneFontFamily = FontFamily(
        Font(R.font.syne_regular, FontWeight.Normal),
        Font(R.font.syne_medium, FontWeight.Medium),
        Font(R.font.syne_bold, FontWeight.Bold),
        Font(R.font.syne_semibold, FontWeight.SemiBold),
        Font(R.font.syne_extrabold, FontWeight.ExtraBold),
    )
}