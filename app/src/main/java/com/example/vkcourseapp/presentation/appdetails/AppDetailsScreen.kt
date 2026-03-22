package com.example.vkcourseapp.presentation.appdetails

import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.vkcourseapp.R
import com.example.vkcourseapp.domain.appdetails.AppDetails
import com.example.vkcourseapp.presentation.theme.VkCourseAppTheme

@Composable
fun AppDetailsScreen(
    modifier: Modifier = Modifier,
) {
    val viewModel = viewModel<AppDetailsViewModel>()
    val state by viewModel.state.collectAsStateWithLifecycle()

    when(val currentState = state) {
        is AppDetailsState.Content -> {
            AppDetailsContent(
                currentState.appDetails
            )
        }
        AppDetailsState.Error -> {
            Box(Modifier
                .fillMaxSize(), Alignment.Center) {
                Text("Ошибка!")
            }
        }
        AppDetailsState.Loading -> {
            Box(Modifier
                .fillMaxSize(), Alignment.Center) {
                CircularProgressIndicator()
            }
        }
    }
}

@Composable
private fun AppDetailsContent(
    appDetails: AppDetails,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    val underDevelopmentText = stringResource(R.string.under_development)

    var descriptionCollapsed by remember { mutableStateOf(false) }

    Column(modifier) {
        Toolbar(
            onBackClick = {
                // TODO: Открыть предыдущий экран через Jetpack Navigation
                Toast.makeText(context, underDevelopmentText, Toast.LENGTH_SHORT).show()
            },
            onShareClick = {
                Toast.makeText(context, underDevelopmentText, Toast.LENGTH_SHORT).show()
            },
        )
        Spacer(Modifier.height(8.dp))
        AppDetailsHeader(
            appDetails = appDetails,
            modifier = Modifier.padding(horizontal = 16.dp),
        )
        Spacer(Modifier.height(16.dp))
        InstallButton(
            onClick = {
                Toast.makeText(context, underDevelopmentText, Toast.LENGTH_SHORT).show()
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        )
        Spacer(Modifier.height(12.dp))
        ScreenshotsList(
            screenshotUrlList = appDetails.screenshotUrlList,
            contentPadding = PaddingValues(horizontal = 16.dp),
        )
        Spacer(Modifier.height(12.dp))
        AppDescription(
            description = appDetails.description,
            collapsed = descriptionCollapsed,
            onReadMoreClick = {
                descriptionCollapsed = true
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
        )
        Spacer(Modifier.height(12.dp))
        HorizontalDivider(
            modifier = Modifier.padding(horizontal = 16.dp),
            color = MaterialTheme.colorScheme.outlineVariant,
        )
        Spacer(Modifier.height(12.dp))
        Developer(
            name = appDetails.developer,
            onClick = {
                Toast.makeText(context, underDevelopmentText, Toast.LENGTH_SHORT).show()
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp),
        )
    }
}

@Preview
@Composable
private fun Preview() {
    VkCourseAppTheme {
        AppDetailsScreen(
            modifier = Modifier.fillMaxSize(),
        )
    }
}