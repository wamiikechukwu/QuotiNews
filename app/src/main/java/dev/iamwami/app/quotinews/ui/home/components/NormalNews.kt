package dev.iamwami.app.quotinews.ui.home

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import dev.iamwami.app.quotinews.db.entity.NewsTable
import dev.iamwami.app.quotinews.ui.components.LikeBtn
import dev.iamwami.app.quotinews.ui.components.NewsImage
import dev.iamwami.app.quotinews.ui.utils.SampleNewsApiDataProvider


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun NormalNews(
    modifier: Modifier = Modifier,
    newsData: NewsTable,
    navigateToArticle: (String) -> Unit,
    onToggleFavourite: MutableState<Boolean>,
) {


    val i = onToggleFavourite
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,

        ) {
        NewsImage(
            newsData = newsData,
            modifier = modifier
                .height(70.dp)
                .width(130.dp)
                .padding(start = 8.dp, end = 12.dp)
        )
        Column(modifier = modifier.weight(1f)) {
            newsData.title?.let {
                Text(
                    text = it,
                    style = MaterialTheme.typography.subtitle1,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                )
            }
            Row(modifier = modifier.padding(top = 8.dp)) {
                newsData.author?.let {
                    Text(
                        style = MaterialTheme.typography.body2,
                        text = it,
                    )
                }
                Spacer(modifier = modifier.width(24.dp))
//                TODO Text returns an error
//                Text(
//                    style = MaterialTheme.typography.body2,
//                    text = newsData.articles?.get(0)?.let { dateFormatter(it.publishedAt) }
//                )
            }
        }

        LikeBtn(
            onCheckedBtnState = onToggleFavourite.value,
            onToggleBtn = {
                onToggleFavourite.value = onToggleFavourite.value != true
            }
        )

    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Preview()
@Composable
fun NewsListPreview(@PreviewParameter(SampleNewsApiDataProvider::class) data: NewsTable) {
    NormalNews(newsData = data,
        navigateToArticle = {},
        onToggleFavourite = remember { mutableStateOf(true) }
    )
}
