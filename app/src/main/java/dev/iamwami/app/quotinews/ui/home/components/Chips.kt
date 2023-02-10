package dev.iamwami.app.quotinews.ui.home.components

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewsChip(
    modifier: Modifier = Modifier,
    isChipEnabled: Boolean = true,
    onClick: () -> Unit,
    label: @Composable () -> Unit,
    leadingIcon: (@Composable () -> Unit),
    trailingIcon: (@Composable () -> Unit)? = null,
    shape: Shape = AssistChipDefaults.shape,
    colors: ChipColors = AssistChipDefaults.assistChipColors(),
    elevation: ChipElevation? = AssistChipDefaults.assistChipElevation(),
    border: ChipBorder? = AssistChipDefaults.assistChipBorder(),
) {
    AssistChip(
        modifier = modifier,
        enabled = isChipEnabled,
        onClick = { onClick()},
        label = { label() },
        leadingIcon = { leadingIcon() },
        trailingIcon = { trailingIcon },
        shape = shape,
        colors = colors,
        elevation = elevation,
        border = border,
    )
}