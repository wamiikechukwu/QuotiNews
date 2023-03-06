package dev.iamwami.app.quotinews.ui.utils

import dev.iamwami.app.quotinews.R

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

