package com.example.vkcourseapp.data.appdetails

import com.example.vkcourseapp.domain.appdetails.Category


data class AppDetailsDto(
    val id: String,
    val name: String,
    val developer: String,
    val category: Category,
    val ageRating: Int,
    val size: Double,
    val icon: String,
    val screenshots: List<String>,
    val description: String,
)