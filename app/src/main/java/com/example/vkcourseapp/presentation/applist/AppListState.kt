package com.example.vkcourseapp.presentation.applist

import androidx.compose.runtime.Immutable
import com.example.vkcourseapp.domain.applist.AppItem


@Immutable
sealed interface AppListState {
    data object Error : AppListState
    data object Loading : AppListState
    data class Content(
        val appItems: List<AppItem>
    ) : AppListState
}