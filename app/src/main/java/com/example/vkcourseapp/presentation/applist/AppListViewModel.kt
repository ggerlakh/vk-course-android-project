package com.example.vkcourseapp.presentation.applist

import androidx.lifecycle.ViewModel
import com.example.vkcourseapp.R
import com.example.vkcourseapp.domain.applist.AppItemDto
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.Channel.Factory.BUFFERED
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlin.collections.listOf
import kotlin.time.Duration.Companion.seconds
import kotlinx.coroutines.delay
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class AppListViewModel : ViewModel() {
    private val _state = MutableStateFlow<AppListState>(AppListState.Loading)
    val state = _state.asStateFlow()

    private val _events = Channel<AppListEvent>(BUFFERED)
    val events = _events.receiveAsFlow()

    init {
        loadAppList()
    }

    fun onImageClick() {
        // Отправляем событие при нажатии на изображение
        viewModelScope.launch {
            _events.send(AppListEvent.ShowSnackbar("Изображение нажато!"))
        }
    }

    // В будущем это будет репозиторий или юзкейс
    fun loadAppList() {
        viewModelScope.launch {
            _state.value = AppListState.Loading

            runCatching {
                // Эмулируем загрузку с бэкенда
                delay(2.seconds)

                val appItemsDto = getAppList()

                _state.value = AppListState.Content(
                    appItems = appItemsDto,
                )
            }.onFailure {
                _state.value = AppListState.Error
            }
        }
    }

    // В будущем заменим этот метод на вызов API.
    private fun getAppList(): List<AppItemDto> = listOf<AppItemDto>(
        AppItemDto(
            iconResId = R.drawable.sber,
            name = "СберБанк Онлайн - с Салютом",
            description = "Больше чем банк",
            category = "Финансы"
        ),
        AppItemDto(
            iconResId = R.drawable.yandex_browser,
            name = "Яндекс.Браузер - с Алисой",
            description = "Больше чем банк",
            category = "Инструменты"
        ),
        AppItemDto(
            iconResId = R.drawable.mailru,
            name = "Почта Mail.ru",
            description = "Почтовый клиент для любых ящиков",
            category = "Инструменты"
        ),
        AppItemDto(
            iconResId = R.drawable.yandex_nav,
            name = "Яндекс Навигатор",
            description = "Парковки и заправки - по пути",
            category = "Транспорт"
        ),
        AppItemDto(
            iconResId = R.drawable.mts,
            name = "Мой МТС",
            description = "Парковки и заправки - по пути",
            category = "Инструменты"
        ),
        AppItemDto(
            iconResId = R.drawable.yandex_alice,
            name = "Яндекс - с Алисой",
            description = "Яндекс - поиск всегда под рукой",
            category = "Инструменты"
        ),
        AppItemDto(
            iconResId = R.drawable.yandex_alice,
            name = "Яндекс - с Алисой",
            description = "Яндекс - поиск всегда под рукой",
            category = "Инструменты"
        ),
        AppItemDto(
            iconResId = R.drawable.yandex_alice,
            name = "Яндекс - с Алисой",
            description = "Яндекс - поиск всегда под рукой",
            category = "Инструменты"
        ),
        AppItemDto(
            iconResId = R.drawable.yandex_alice,
            name = "Яндекс - с Алисой",
            description = "Яндекс - поиск всегда под рукой",
            category = "Инструменты"
        ),
        AppItemDto(
            iconResId = R.drawable.yandex_alice,
            name = "Яндекс - с Алисой",
            description = "Яндекс - поиск всегда под рукой",
            category = "Инструменты"
        ),
    )
}