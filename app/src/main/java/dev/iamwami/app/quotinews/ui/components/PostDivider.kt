package dev.iamwami.app.quotinews.ui.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

/* full width divider with padding*/
@Composable
fun PostDivider() {
    Divider(
        modifier = Modifier
            .padding(14.dp),
        color = MaterialTheme.colors.onSurface.copy(alpha = 0.08f)
    )
}