package com.example.vkcourseapp.presentation.applist

import androidx.lifecycle.ViewModel
import com.example.vkcourseapp.R
import com.example.vkcourseapp.domain.applist.AppItem
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.Channel.Factory.BUFFERED
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlin.collections.listOf
import kotlin.time.Duration.Companion.seconds
import kotlinx.coroutines.delay
import androidx.lifecycle.viewModelScope
import com.example.vkcourseapp.data.applist.AppItemMapper
import com.example.vkcourseapp.data.applist.AppListApi
import com.example.vkcourseapp.data.applist.AppListRepositoryImpl
import com.example.vkcourseapp.data.applist.CategoryMapper
import com.example.vkcourseapp.domain.applist.AppListRepository
import com.example.vkcourseapp.domain.applist.GetAppListUseCase
import kotlinx.coroutines.launch

class AppListViewModel : ViewModel() {

    // В будущем репозиторий будет создаваться автоматический через инъекцию зависимостей
    private val getAppListUseCase = GetAppListUseCase(
        appListRepository = AppListRepositoryImpl(
            mapper = AppItemMapper(categoryMapper = CategoryMapper()),
            api = AppListApi()
        )
    )
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

                val appItemsDto = getAppListUseCase()

                _state.value = AppListState.Content(
                    appItems = appItemsDto,
                )
            }.onFailure {
                _state.value = AppListState.Error
            }
        }
    }

}