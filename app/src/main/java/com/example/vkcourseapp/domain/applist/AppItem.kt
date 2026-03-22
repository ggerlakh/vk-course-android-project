package com.example.vkcourseapp.domain.applist


data class AppItem(
    val iconResId: Int,
    val name: String,
    val description: String,
    val category: Category,
)