package com.example.vkcourseapp.presentation.appdetails

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.vkcourseapp.R
import kotlinx.coroutines.flow.Flow
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import com.example.vkcourseapp.presentation.theme.VkCourseAppTheme

@Composable
fun AppDetailsScreen(
    viewModel: AppDetailsViewModel,
    onBackClick: () -> Unit,
) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    val events = viewModel.events

    val snackbarHostState = remember { SnackbarHostState() }

    ObserveEvents(
        events = events,
        snackbarHostState = snackbarHostState,
    )

    Scaffold(
        snackbarHost = {
            SnackbarHost(snackbarHostState)
        },
        modifier = Modifier.background(MaterialTheme.colorScheme.surface)
    ) { contentPadding ->
        when (val currentState = state) {
            is AppDetailsState.Content -> {
                AppDetailsContent(
                    content = currentState,
                    onBackClick = onBackClick,
                    onFavoriteClick = {
                        viewModel.toggleWishlist()
                    },
                    onShareClick = {
                        viewModel.showUnderDevelopmentMessage()
                    },
                    onInstallClick = {
                        viewModel.showUnderDevelopmentMessage()
                    },
                    onReadMoreClick = {
                        viewModel.collapseDescription()
                    },
                    onDeveloperClick = {
                        viewModel.showUnderDevelopmentMessage()
                    },
                    modifier = Modifier.fillMaxSize()
                )
            }

            AppDetailsState.Error -> {
                Box(
                    modifier = Modifier.fillMaxSize()
                        .safeDrawingPadding()
                        .padding(contentPadding),
                    Alignment.Center
                ) {
                    Text("Ошибка!")
                }
            }

            AppDetailsState.Loading -> {
                Box(
                    modifier = Modifier.fillMaxSize()
                        .safeDrawingPadding()
                        .padding(contentPadding), Alignment.Center
                ) {
                    CircularProgressIndicator()
                }
            }
        }
    }
}

@Composable
private fun ObserveEvents(
    events: Flow<AppDetailsEvent>,
    snackbarHostState: SnackbarHostState,
) {
    val underDevelopementText = stringResource(R.string.under_development)

    LaunchedEffect(Unit) {
        events.collect { event ->
            when (event) {
                is AppDetailsEvent.UnderDevelopment -> {
                    snackbarHostState.showSnackbar(underDevelopementText)
                }
            }
        }
    }
}

@Preview
@Composable
private fun Preview() {
    VkCourseAppTheme {
        val appDetailsViewModel = viewModel<AppDetailsViewModel>()
        AppDetailsScreen(appDetailsViewModel) {}
    }
}