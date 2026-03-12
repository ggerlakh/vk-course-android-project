package com.example.vkcourseapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import com.example.vkcourseapp.models.AppDetailsDto

@Composable
fun AppItem(
    appDetailsItem: AppDetailsDto,
    size: Dp
) {
    Row(Modifier
        .fillMaxWidth()
        .clip(RoundedCornerShape(topStart = 12.dp, topEnd = 12.dp))
        .background(Color(0xFFFFFFFF))) {
        Image(
            painter = appDetailsItem.painter,
            contentDescription = null,
            modifier = Modifier
                .size(size)
                .padding(top = 8.dp),
//            verticalAlignment = Alignment.CenterVertically,
//            horizontalAlignment = Alignment.CenterHorizontally
        )
        Column(
//            Modifier
//            .padding(top = 16.dp)
        ) {
            Text(
                text = appDetailsItem.name,
                modifier = Modifier.padding(4.dp),
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp
            )
            Text(
                text = appDetailsItem.description,
                modifier = Modifier.padding(4.dp),
                fontWeight = FontWeight.Bold
            )
            Text(
                text = appDetailsItem.type,
                modifier = Modifier.padding(4.dp),
                color = Color.Gray
            )
        }
    }
}

@Composable
fun AppDetailsScreen() {
    val appItemsDto = listOf<AppDetailsDto>(
        AppDetailsDto(
            painter = painterResource(R.drawable.sber),
            name = "СберБанк Онлайн - с Салютом",
            description = "Больше чем банк",
            type = "Финансы"
        ),
        AppDetailsDto(
            painter = painterResource(R.drawable.yandex_browser),
            name = "Яндекс.Браузер - с Алисой",
            description = "Больше чем банк",
            type = "Финансы"
        ),
        AppDetailsDto(
            painter = painterResource(R.drawable.mailru),
            name = "Почта Mail.ru",
            description = "Почтовый клиент для любых ящиков",
            type = "Инструменты"
        ),
        AppDetailsDto(
            painter = painterResource(R.drawable.yandex_nav),
            name = "Яндекс Навигатор",
            description = "Парковки и заправки - по пути",
            type = "Транспорт"
        ),
        AppDetailsDto(
            painter = painterResource(R.drawable.mts),
            name = "Мой МТС",
            description = "Парковки и заправки - по пути",
            type = "Инструменты"
        ),
        AppDetailsDto(
            painter = painterResource(R.drawable.yandex_alice),
            name = "Яндекс - с Алисой",
            description = "Яндекс - поиск всегда под рукой",
            type = "Инструменты"
        ),
    )
    Column(
        Modifier.verticalScroll(rememberScrollState())
    ) {
            Row(
                Modifier
                    .fillMaxWidth()
                    .height(90.dp)
                    .background(Color(0xFF0077FF)),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Image(
                    painter = painterResource(id = R.drawable.rustore),
                    contentDescription = null,
                    modifier = Modifier.size(120.dp)
                )
                Spacer(Modifier.weight(1f))
                Image(
                    painter = painterResource(id = R.drawable.view_comfy_alt_24px),
                    contentDescription = null,
                    modifier = Modifier
                        .size(40.dp)
                        .padding(end = 20.dp)
                )
            }
            appItemsDto.forEach { appItemDto ->
                AppItem(
                    appDetailsItem = appItemDto,
                    size = 90.dp
                )
            }
        }
}


@Preview
@Composable
private fun Preview() {
    AppDetailsScreen()
}