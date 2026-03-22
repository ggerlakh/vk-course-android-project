package com.example.vkcourseapp.presentation.navigation

import androidx.compose.foundation.layout.padding
import androidx.navigation.compose.rememberNavController
import com.example.vkcourseapp.presentation.theme.VkCourseAppTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import com.example.vkcourseapp.presentation.applist.AppListScreen
import com.example.vkcourseapp.presentation.appdetails.AppDetailsScreen
import androidx.navigation.compose.composable
import com.example.vkcourseapp.presentation.applist.AppListViewModel

sealed class Routes(val route: String) {

    object Home : Routes("home")
    object AppDetails : Routes("app_details")
}

@Composable
fun App() {
    VkCourseAppTheme {
        val navController = rememberNavController()
        val appListViewModel = hiltViewModel<AppListViewModel>()

        Scaffold(
            containerColor = MaterialTheme.colorScheme.background
        ) { padding ->
            NavHost(
                navController = navController,
                startDestination = Routes.Home.route,
                modifier = Modifier
                    .padding(padding),
            ) {
                composable(Routes.Home.route) {
                    /*
                    Передаем лямбду для перехода с домашнего экрана со списком приложений
                    для перехода на экран с карточкой из практики по клику на AppItem
                    */
                    AppListScreen(
                        onAppClick = { navController.navigate(Routes.AppDetails.route) },
                        viewModel = appListViewModel
                    )

                }

                composable(Routes.AppDetails.route) {
                    AppDetailsScreen()
                }
            }
        }
    }
}