package dev.iamwami.app.quotinews.ui.components

import android.widget.Toast
import androidx.compose.material.Icon
import androidx.compose.material.IconToggleButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext

@Composable
fun LikeBtn(
    modifier: Modifier = Modifier,
    onCheckedBtnState: Boolean,
    onToggleBtn: (() -> Unit)
) {
    val context = LocalContext.current
    val message = if (onCheckedBtnState) "Added to bookmark" else "removed from bookmark"

    IconToggleButton(
        checked = onCheckedBtnState,
        onCheckedChange = {
            onToggleBtn()
            Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
        }
    ) {

        Icon(
            imageVector = if (onCheckedBtnState) Icons.Outlined.FavoriteBorder else Icons.Outlined.Favorite,
            contentDescription = "Heart icon for favourite news"
        )
    }
}