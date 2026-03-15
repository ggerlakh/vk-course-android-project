package com.example.vkcourseapp.domain.applist

import androidx.compose.ui.graphics.painter.Painter

data class AppItemDto(
    val name: String,
    val description: String,
    val category: String,
    val painter: Painter,
)