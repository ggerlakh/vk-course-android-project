package com.example.vkcourseapp.presentation.applist

sealed interface AppListEvent {
    data class ShowSnackbar(
        val message: String,
    ) : AppListEvent
}