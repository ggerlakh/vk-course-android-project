package com.example.vkcourseapp.presentation.applist

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.vkcourseapp.domain.applist.AppItem
import com.example.vkcourseapp.presentation.theme.VkCourseAppTheme
import kotlinx.coroutines.flow.Flow
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.remember
import androidx.compose.material3.SnackbarHost


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun AppListScreen(
    onAppClick: () -> Unit,
    viewModel: AppListViewModel
) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    val snackbarHostState = remember { SnackbarHostState() }

    Scaffold(
        snackbarHost = {
            SnackbarHost(snackbarHostState)
        },
    ) {
        when(val currentState = state) {
            is AppListState.Content -> {
                AppListContent(
                    onAppClick = onAppClick,
                    viewModel = viewModel,
                    snackbarHostState = snackbarHostState,
                    appItems = currentState.appItems,
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color(0xFF0077FF))
                )
            }
            AppListState.Error -> {
                AppListError(
                    Modifier.fillMaxSize(),
                    Alignment.Center
                )
            }
            AppListState.Loading -> {
                AppListLoading(
                    Modifier.fillMaxSize(),
                    Alignment.Center
                )
            }
        }
    }
}

@Composable
private fun AppListError(
    modifier: Modifier,
    alignment: Alignment
) {
    Box(modifier, alignment) {
        Text("Ошибка!")
    }
}

@Composable
private fun AppListLoading(
    modifier: Modifier,
    alignment: Alignment
) {
    Box(modifier, alignment) {
        CircularProgressIndicator()
    }
}

@Composable
private fun AppListContent(
    onAppClick: () -> Unit,
    viewModel: AppListViewModel,
    snackbarHostState: SnackbarHostState,
    appItems: List<AppItem>,
    modifier: Modifier
) {
    Column(
        modifier
    ) {
        AppListHeader(
            viewModel,
            snackbarHostState,
            Modifier
                .fillMaxWidth()
                .height(90.dp)
                .background(Color(0xFF0077FF))
        )
        AppList(onAppClick, appItems)
    }
}

@Composable
private fun ObserveEvents(
    events: Flow<AppListEvent>,
    snackbarHostState: SnackbarHostState,
) {
    LaunchedEffect(events) {
        events.collect { event ->
            when(event) {
                is AppListEvent.ShowSnackbar -> {
                    snackbarHostState.showSnackbar(event.message)
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun HomeScreenPreview() {
    VkCourseAppTheme {
        val appListViewModel = viewModel<AppListViewModel>()
        AppListScreen({}, appListViewModel)
    }
}