package com.example.vkcourseapp.presentation.applist

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.vkcourseapp.domain.applist.AppItem
import androidx.compose.foundation.lazy.items


@Composable
fun AppList(
    onAppClick: () -> Unit,
    appItems: List<AppItem>
    ) {
    LazyColumn(
        Modifier.fillMaxSize()
    ) {
            items(appItems) { appItemDto ->
                AppItem(
                    appDetailsItem = appItemDto,
                    size = 90.dp,
                    onClick = onAppClick,
                )
            }
        }
}


