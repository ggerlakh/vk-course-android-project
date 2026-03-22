package com.example.vkcourseapp.presentation.appdetails

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.vkcourseapp.data.appdetails.AppDetailsRepositoryImpl
import com.example.vkcourseapp.domain.appdetails.GetAppDetailsUseCase
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class AppDetailsViewModel : ViewModel() {

    private val getAppDetailsUseCase = GetAppDetailsUseCase(
        // Подстановку реализации должен делать DI.
        // Будет доработано в следующих лекциях.
        appDetailsRepository = AppDetailsRepositoryImpl(),
    )

    private val _state = MutableStateFlow<AppDetailsState>(AppDetailsState.Loading)
    val state = _state.asStateFlow()


    init {
        loadApp()
    }

    fun loadApp() {
        viewModelScope.launch {
            runCatching {
                _state.value = AppDetailsState.Loading
                delay(2000L)
                val app = getAppDetailsUseCase("e94ruf4")
                _state.value = AppDetailsState.Content(app)
            }.onFailure {
                _state.value = AppDetailsState.Error
            }
        }
    }


}