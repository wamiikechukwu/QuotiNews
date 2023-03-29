package dev.iamwami.app.quotinews.ui.home.components

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import dev.iamwami.app.quotinews.R

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


object AssistChipDetails {
    data class Category(
        val name: String,
        val icon: Int
    )

    fun chipCategory(): List<Category> {
        val chipMap: MutableList<Category> = mutableListOf()
        chipMap.add(Category("Tech", R.drawable.engineering))
        chipMap.add(Category("Edu", R.drawable.books))
        chipMap.add(Category("Govt", R.drawable.govt))
        chipMap.add(Category("Fashion", R.drawable.fashion))
        chipMap.add(Category("Health", R.drawable.health))
        chipMap.add(Category("Econs", R.drawable.stock_chart))

        return chipMap.toList()
    }
}