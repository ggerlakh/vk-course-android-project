package com.example.vkcourseapp.data.applist

import com.example.vkcourseapp.R
import kotlinx.coroutines.delay
import kotlin.time.Duration.Companion.seconds

class AppListApi {
    suspend fun get(): List<AppItemDto> {
        // Эмулируем загрузку с бэкенда
        delay(2.seconds)
        val apps = listOf(
            AppItemDto(
                id = R.drawable.sber,
                name = "СберБанк Онлайн - с Салютом",
                description = "Больше чем банк",
                category = "Финансы"
            ),
            AppItemDto(
                id = R.drawable.yandex_browser,
                name = "Яндекс.Браузер - с Алисой",
                description = "Больше чем банк",
                category = "Инструменты"
            ),
            AppItemDto(
                id = R.drawable.mailru,
                name = "Почта Mail.ru",
                description = "Почтовый клиент для любых ящиков",
                category = "Инструменты"
            ),
            AppItemDto(
                id = R.drawable.yandex_nav,
                name = "Яндекс Навигатор",
                description = "Парковки и заправки - по пути",
                category = "Транспорт"
            ),
            AppItemDto(
                id = R.drawable.mts,
                name = "Мой МТС",
                description = "Парковки и заправки - по пути",
                category = "Инструменты"
            ),
            AppItemDto(
                id = R.drawable.yandex_alice,
                name = "Яндекс - с Алисой",
                description = "Яндекс - поиск всегда под рукой",
                category = "Инструменты"
            ),
            AppItemDto(
                id = R.drawable.yandex_alice,
                name = "Яндекс - с Алисой",
                description = "Яндекс - поиск всегда под рукой",
                category = "Инструменты"
            ),
            AppItemDto(
                id = R.drawable.yandex_alice,
                name = "Яндекс - с Алисой",
                description = "Яндекс - поиск всегда под рукой",
                category = "Инструменты"
            ),
            AppItemDto(
                id = R.drawable.yandex_alice,
                name = "Яндекс - с Алисой",
                description = "Яндекс - поиск всегда под рукой",
                category = "Инструменты"
            ),
            AppItemDto(
                id = R.drawable.yandex_alice,
                name = "Яндекс - с Алисой",
                description = "Яндекс - поиск всегда под рукой",
                category = "Инструменты"
            ),
        )
        return apps
    }
}