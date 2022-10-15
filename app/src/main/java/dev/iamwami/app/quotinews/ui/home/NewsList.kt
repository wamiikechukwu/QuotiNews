package dev.iamwami.app.quotinews.ui.home

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.iamwami.app.quotinews.model.NewsApiResult
import dev.iamwami.app.quotinews.ui.components.NewsImageSmall

@Composable
fun NewsList(modifier: Modifier = Modifier, newsData: NewsApiResult) {
    Divider(thickness = 1.dp, color = Color.Black)
    Row() {
        NewsImageSmall(
            newsData = newsData,
            modifier = Modifier
                .height(200.dp)
                .width(350.dp)
                .clip(shape = MaterialTheme.shapes.medium)
        )
    }
}

@Preview
@Composable
fun NewsListPreview() {
//    NewsList()
}