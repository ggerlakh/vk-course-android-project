package com.example.vkcourseapp.presentation.applist

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.vkcourseapp.R


@Composable
fun AppListHeader(
    viewModel: AppListViewModel,
    snackbarHostState: SnackbarHostState,
    modifier: Modifier
) {
    // Наблюдаем за событиями
    LaunchedEffect(viewModel.events) {
        viewModel.events.collect { event ->
            when(event) {
                is AppListEvent.ShowSnackbar -> {
                    snackbarHostState.showSnackbar(event.message)
                }
            }
        }
    }

    Row(
        modifier
    ) {
        Image(
            painter = painterResource(id = R.drawable.rustore),
            contentDescription = null,
            modifier = Modifier.size(120.dp).clickable {
                viewModel.onImageClick()
            }
        )
        Spacer(Modifier.weight(1f))
        Image(
            painter = painterResource(id = R.drawable.view_comfy_alt_24px),
            contentDescription = null,
            modifier = Modifier
                .size(60.dp)
                .padding(top = 10.dp, end = 20.dp)
        )
    }
}