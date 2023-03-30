package dev.iamwami.app.quotinews.ui.screens.components

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.Dp
import dev.iamwami.app.quotinews.ui.theme.Fonts

/*
* This is the Top Bar for all screens [Home, Bookmark]
* */
@Composable
fun TopBar(
    elevation: Dp,
    topBarTitle: String,
    topBarIcon: ImageVector,
    openDrawer: () -> Unit,
) {

//    TODO: Use CenterAlignedTopAppBar to center the items in the top bar
    val context = LocalContext.current
    TopAppBar(
        title = {
            Row(horizontalArrangement = Arrangement.Center, modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = topBarTitle,
                    fontFamily = Fonts.syneFontFamily
                )
            }
        },
        navigationIcon = {
            IconButton(onClick = openDrawer) {
                Icon(topBarIcon, contentDescription = "navigation menu")
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