package com.example.vkcourseapp.models

import androidx.compose.ui.graphics.painter.Painter

data class AppDetailsDto(
    val name: String,
    val description: String,
    val type: String,
    val painter: Painter,
)