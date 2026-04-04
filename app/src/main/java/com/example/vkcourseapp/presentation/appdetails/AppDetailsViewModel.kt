package com.example.vkcourseapp.presentation.appdetails

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.vkcourseapp.domain.appdetails.GetAppDetailsUseCase
import com.example.vkcourseapp.domain.appdetails.ObserveAppDetailsUseCase
import com.example.vkcourseapp.domain.appdetails.ToggleWishlistAppDetailsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.Channel.Factory.BUFFERED
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.flow.catch
import javax.inject.Inject

@HiltViewModel
class AppDetailsViewModel @Inject constructor(
    private val getAppDetailsUseCase: GetAppDetailsUseCase,
    private val observeAppDetailsUseCase: ObserveAppDetailsUseCase,
    private val toggleWishlistAppDetailsUseCase: ToggleWishlistAppDetailsUseCase,
    savedStateHandle: SavedStateHandle,
) : ViewModel() {

    val appId: String = savedStateHandle["appId"] ?: ""

    private val _state = MutableStateFlow<AppDetailsState>(AppDetailsState.Loading)
    val state = _state.asStateFlow()

    private val _events = Channel<AppDetailsEvent>(BUFFERED)
    val events = _events.receiveAsFlow()


    init {
//        loadApp()
        observeAppDetails()
    }

    fun loadApp() {
        viewModelScope.launch {
            runCatching {
                _state.value = AppDetailsState.Loading
                val app = getAppDetailsUseCase(appId)
                _state.value = AppDetailsState.Content(appDetails = app, descriptionCollapsed = false, isInWishlist = false)
            }.onFailure {
                Log.d("AppDetailsViewModel", "ERROR : $it")
                _state.value = AppDetailsState.Error
            }
        }
    }

    fun showUnderDevelopmentMessage() {
        viewModelScope.launch {
            _events.send(AppDetailsEvent.UnderDevelopment)
        }
    }

    fun collapseDescription() {
        _state.update { currentState ->
            if (currentState is AppDetailsState.Content) {
                currentState.copy(descriptionCollapsed = true)
            } else {
                currentState
            }
        }
    }

    fun toggleWishlist() {
        viewModelScope.launch {
            toggleWishlistAppDetailsUseCase(appId)
        }
    }

    private fun observeAppDetails() {
        viewModelScope.launch {
            observeAppDetailsUseCase(appId)
                .catch {
                    Log.d("AppDetailsViewModel", "ERROR (observeAppDetails) : $it")
                    _state.value = AppDetailsState.Error
                }
                .collect { appDetails ->
                    _state.value = AppDetailsState.Content(
                        appDetails = appDetails,
                        descriptionCollapsed = false,
                        isInWishlist = appDetails.isInWishlist,
                    )
                }
        }
    }
}