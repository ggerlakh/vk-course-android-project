package com.example.vkcourseapp.presentation.appdetails

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.vkcourseapp.data.appdetails.AppDetailsRepositoryImpl
import com.example.vkcourseapp.domain.appdetails.GetAppDetailsUseCase
import com.example.vkcourseapp.domain.applist.GetAppListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AppDetailsViewModel @Inject constructor(
    private val getAppDetailsUseCase: GetAppDetailsUseCase,
    savedStateHandle: SavedStateHandle,
) : ViewModel() {

    val appId: String = savedStateHandle["appId"] ?: ""

    private val _state = MutableStateFlow<AppDetailsState>(AppDetailsState.Loading)
    val state = _state.asStateFlow()


    init {
        loadApp()
    }

    fun loadApp() {
        viewModelScope.launch {
            runCatching {
                _state.value = AppDetailsState.Loading
                val app = getAppDetailsUseCase(appId)
                _state.value = AppDetailsState.Content(app)
            }.onFailure {
                Log.d("AppDetailsViewModel", "ERROR : $it")
                _state.value = AppDetailsState.Error
            }
        }
    }
}