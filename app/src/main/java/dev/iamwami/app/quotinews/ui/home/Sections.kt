package dev.iamwami.app.quotinews.ui.home

import android.os.Build
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.AssistChipDefaults
import androidx.compose.material3.ChipBorder
import androidx.compose.material3.ChipColors
import androidx.compose.material3.ChipElevation
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import dev.iamwami.app.quotinews.model.News
import dev.iamwami.app.quotinews.ui.components.PostDivider
import dev.iamwami.app.quotinews.ui.home.components.NewsChip
import dev.iamwami.app.quotinews.ui.home.components.RelatedNews
import dev.iamwami.app.quotinews.ui.theme.Fonts
import dev.iamwami.app.quotinews.ui.utils.AssistChipDetails

@Composable
fun PopularNewsSection(
    newsDataList: List<News>,
    isFavourite: Set<String>,
    onFavouriteToggle: MutableState<Boolean>,
    modifier: Modifier = Modifier,
) {
    Column {
        Text(
            modifier = modifier.padding(vertical = 16.dp),
            text = "Popular News for you",
            style = MaterialTheme.typography.subtitle1
        )
        LazyRow(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
            items(newsDataList) { news ->
                PopularNews(
                    newsData = news,
                    isIconBookmarked = false,
                    iconClicked = { }
                )
            }
        }
        PostDivider()
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun NormalNewsSection(
    modifier: Modifier = Modifier,
    newsData: News,
    navigateToArticle: (String) -> Unit,
    onToggleFavourite: MutableState<Boolean>
) {
    NormalNews(
        newsData = newsData,
        navigateToArticle = navigateToArticle,
        onToggleFavourite = onToggleFavourite
    )
    PostDivider()
}

/*
* This is the Top Bar
* */
@Composable
fun TopBar(
    elevation: Dp,
    openDrawer: () -> Unit,
) {

    val context = LocalContext.current
    TopAppBar(
        title = {
            Row(horizontalArrangement = Arrangement.Center, modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = "QuotiNews",
                    fontFamily = Fonts.syneFontFamily
                )
            }
        },
        navigationIcon = {
            IconButton(onClick = {
                openDrawer.invoke()
            }) {
                Icon(Icons.Outlined.Menu, contentDescription = "navigation menu")
            }
        },
        actions = {
            IconButton(onClick = {
                Toast.makeText(context, "Functionality not available", Toast.LENGTH_SHORT).show()
            }) {
                Icon(Icons.Outlined.Search, contentDescription = "search icon")
            }
        },

        elevation = elevation,
        backgroundColor = MaterialTheme.colors.surface
    )
}

/*
* This is the related news
* */
@Composable
fun RelatedNewsSection(
    newsData: News,
    modifier: Modifier = Modifier,
    onToggleLikeBtn: MutableState<Boolean>
) {
    RelatedNews(
        newsData = newsData,
        modifier = modifier,
        onToggleLikeBtn = onToggleLikeBtn
    )
}

/*
* This is the Chips, shows different news category
* */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewsChipCategory(
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    shape: Shape = AssistChipDefaults.shape,
    colors: ChipColors = AssistChipDefaults.assistChipColors(),
    elevation: ChipElevation? = AssistChipDefaults.assistChipElevation(),
    border: ChipBorder? = AssistChipDefaults.assistChipBorder(),
) {

    val context = LocalContext.current

    LazyRow(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
        items(AssistChipDetails.chipCategory()) { data ->
            NewsChip(
                onClick = {
                    Toast.makeText(context, "Functionality not yet implemented", Toast.LENGTH_SHORT).show()
                },
                label = { Text(text = data.name) },
                modifier = modifier,
                isChipEnabled = enabled,
                leadingIcon = {
                    Icon(
                        painter = painterResource(id = data.icon),
                        contentDescription = data.name,
                        Modifier.size(AssistChipDefaults.IconSize)
                    )
                },
                trailingIcon = {},
                shape = shape,
                colors = colors,
                elevation = elevation,
                border = border

            )
        }
    }
}


