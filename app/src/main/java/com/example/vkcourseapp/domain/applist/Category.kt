package com.example.vkcourseapp.domain.applist

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class Category(val displayName: String) {
    @SerialName("Финансы")
    FINANCE("Финансы"),

    @SerialName("Инструменты")
    TOOLS("Инструменты"),

    @SerialName("Транспорт")
    TRANSPORT("Транспорт"),
}