package dev.iamwami.app.quotinews.ui.home.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.iamwami.app.quotinews.model.News
import dev.iamwami.app.quotinews.ui.components.LikeBtn
import dev.iamwami.app.quotinews.ui.components.NewsImage
import dev.iamwami.app.quotinews.ui.components.PostDivider
import dev.iamwami.app.quotinews.ui.utils.SampleNewsApiDataProvider

@Composable
fun RelatedNews(
    newsData: News,
    modifier: Modifier = Modifier,
    onToggleLikeBtn: MutableState<Boolean>
) {

    Column {
        newsData.articles?.get(0)?.let {
            Text(text = "Related News")
            Spacer(modifier = Modifier.height(15.dp))
            Box(contentAlignment = Alignment.BottomStart) {

                NewsImage(
                    newsData = newsData,
                    contentDescription = "news image for related news",
                    modifier = modifier.clip(RoundedCornerShape(5.dp))
                )

                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = modifier
                        .fillMaxWidth()
                        .align(alignment = Alignment.TopStart)
                        .padding(start = 12.dp)
                ) {
                    Text(
                        text = "12-12-2022",
                        style = MaterialTheme.typography.body2,
                    )

                    LikeBtn(
                        onCheckedBtnState = onToggleLikeBtn.value,
                        onToggleBtn = {
                            onToggleLikeBtn.value = onToggleLikeBtn.value != true
                        }
                    )
                }

                Text(
                    text = it.title,
                    style = TextStyle(
                        fontWeight = FontWeight.Normal,
                        fontSize = 16.sp,
                        letterSpacing = 0.5.sp,
                        shadow = Shadow(
                            color = Color.White,
                            offset = Offset(x = 2F, y = 2F),
                            blurRadius = 2F
                        )
                    ),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    modifier = modifier
                        .align(alignment = Alignment.BottomStart)
                        .padding(start = 5.dp, end = 8.dp, bottom = 8.dp),
                    fontSize = 19.sp,
                    fontWeight = FontWeight.Bold

                )
            }

            Text(
                text = it.description,
                style = MaterialTheme.typography.subtitle1,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                modifier = modifier.padding(top = 10.dp)
            )
            Spacer(modifier = Modifier.height(8.dp))
            PostDivider()
        }
    }
}


@Preview()
@Composable
fun RelatedNewsPreview(@PreviewParameter(SampleNewsApiDataProvider::class) data: News) {
    RelatedNews(newsData = data,
        onToggleLikeBtn = remember { mutableStateOf(true) }
    )
}