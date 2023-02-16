package dev.iamwami.app.quotinews.ui.components

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext

@Composable
fun LikeButton(modifier: Modifier = Modifier) {
    val context = LocalContext.current
    IconButton(
        onClick = {
            // TODO : Do Something onLikeButtonClicked
//            Toast.makeText(context, "Functionality not available", Toast.LENGTH_SHORT).show()
        }
    ) {
        Icon(Icons.Outlined.FavoriteBorder, contentDescription = "Heart icon for favourite news")
    }
}