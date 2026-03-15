package com.example.vkcourseapp.ui.applist

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.vkcourseapp.domain.applist.AppItemDto
import com.example.vkcourseapp.R
import androidx.compose.foundation.lazy.items
import com.example.vkcourseapp.domain.appdetails.Category
import com.example.vkcourseapp.ui.appdetails.getCategoryText


@Composable
fun AppList(
    onAppClick: () -> Unit,
    ) {
    val appItemsDto = listOf<AppItemDto>(
        AppItemDto(
            painter = painterResource(R.drawable.sber),
            name = "СберБанк Онлайн - с Салютом",
            description = "Больше чем банк",
            category = getCategoryText(Category.FINANCE)
        ),
        AppItemDto(
            painter = painterResource(R.drawable.yandex_browser),
            name = "Яндекс.Браузер - с Алисой",
            description = "Больше чем банк",
            category = getCategoryText(Category.TOOLS)
        ),
        AppItemDto(
            painter = painterResource(R.drawable.mailru),
            name = "Почта Mail.ru",
            description = "Почтовый клиент для любых ящиков",
            category = getCategoryText(Category.TOOLS)
        ),
        AppItemDto(
            painter = painterResource(R.drawable.yandex_nav),
            name = "Яндекс Навигатор",
            description = "Парковки и заправки - по пути",
            category = getCategoryText(Category.TRANSPORT)
        ),
        AppItemDto(
            painter = painterResource(R.drawable.mts),
            name = "Мой МТС",
            description = "Парковки и заправки - по пути",
            category = getCategoryText(Category.TOOLS)
        ),
        AppItemDto(
            painter = painterResource(R.drawable.yandex_alice),
            name = "Яндекс - с Алисой",
            description = "Яндекс - поиск всегда под рукой",
            category = getCategoryText(Category.TOOLS)
        ),
        AppItemDto(
            painter = painterResource(R.drawable.yandex_alice),
            name = "Яндекс - с Алисой",
            description = "Яндекс - поиск всегда под рукой",
            category = getCategoryText(Category.TOOLS)
        ),
        AppItemDto(
            painter = painterResource(R.drawable.yandex_alice),
            name = "Яндекс - с Алисой",
            description = "Яндекс - поиск всегда под рукой",
            category = getCategoryText(Category.TOOLS)
        ),
        AppItemDto(
            painter = painterResource(R.drawable.yandex_alice),
            name = "Яндекс - с Алисой",
            description = "Яндекс - поиск всегда под рукой",
            category = getCategoryText(Category.TOOLS)
        ),
        AppItemDto(
            painter = painterResource(R.drawable.mailru),
            name = "Почта Mail.ru",
            description = "Почтовый клиент для любых ящиков",
            category = getCategoryText(Category.TOOLS)
        ),
    )
    LazyColumn(
        Modifier.fillMaxSize()
    ) {
            items(appItemsDto) { appItemDto ->
                AppItem(
                    appDetailsItem = appItemDto,
                    size = 90.dp,
                    onClick = onAppClick,
                )
            }
        }
}


