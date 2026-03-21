package com.example.vkcourseapp.presentation.applist

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
import com.example.vkcourseapp.presentation.appdetails.getCategoryText


@Composable
fun AppList(
    onAppClick: () -> Unit,
    appItems: List<AppItemDto>
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


