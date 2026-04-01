package com.example.vkcourseapp.domain.appdetails

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
enum class Category {
    @SerialName("Приложения")
    APP,

    @SerialName("Игры")
    GAME,

    @SerialName("Производительность")
    PRODUCTIVITY,

    @SerialName("Социальные сети")
    SOCIAL,

    @SerialName("Образование")
    EDUCATION,

    @SerialName("Развлечения")
    ENTERTAINMENT,

    @SerialName("Музыка")
    MUSIC,

    @SerialName("Видео")
    VIDEO,

    @SerialName("Фото и видео")
    PHOTOGRAPHY,

    @SerialName("Здоровье и фитнес")
    HEALTH,

    @SerialName("Спорт")
    SPORTS,

    @SerialName("Новости")
    NEWS,

    @SerialName("Книги")
    BOOKS,

    @SerialName("Бизнес")
    BUSINESS,

    @SerialName("Финансы")
    FINANCE,

    @SerialName("Путешествия")
    TRAVEL,

    @SerialName("Карты")
    MAPS,

    @SerialName("Еда и напитки")
    FOOD,

    @SerialName("Покупки")
    SHOPPING,

    @SerialName("Утилиты")
    UTILITIES
}