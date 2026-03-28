package com.example.vkcourseapp.presentation.navigation

import androidx.compose.foundation.layout.padding
import androidx.navigation.compose.rememberNavController
import com.example.vkcourseapp.presentation.theme.VkCourseAppTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import com.example.vkcourseapp.presentation.applist.AppListScreen
import com.example.vkcourseapp.presentation.appdetails.AppDetailsScreen
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.vkcourseapp.presentation.applist.AppListViewModel
import com.example.vkcourseapp.presentation.appdetails.AppDetailsViewModel

sealed class Routes(val route: String) {

    object Home : Routes("home")
    data class AppDetails(val appId: String) : Routes("app_details/{appId}") {
        fun passId(): String = "app_details/$appId"

        companion object {
            // Для получения аргументов в composable
            val arguments = listOf(
                navArgument("appId") { type = NavType.StringType }
            )
        }
    }
}

@Composable
fun App() {
    VkCourseAppTheme {
        val navController = rememberNavController()

        Scaffold(
            containerColor = MaterialTheme.colorScheme.background
        ) { padding ->
            NavHost(
                navController = navController,
                startDestination = Routes.Home.route,
                modifier = Modifier
                    .padding(padding),
            ) {
                // Экран со списком приложений
                composable(Routes.Home.route) {
                    /*
                    Передаем лямбду для перехода с домашнего экрана со списком приложений
                    для перехода на экран с карточкой из практики по клику на AppItem
                    */
                    val appListViewModel = hiltViewModel<AppListViewModel>()
                    AppListScreen(
                        onAppClick = { appId ->
                            // Переход с передачей appId
                            navController.navigate(Routes.AppDetails(appId).passId())
                        },
                        viewModel = appListViewModel
                    )
                }

                // Экран деталей с получением appId из аргументов
                composable(
                    route = Routes.AppDetails("").route,  // Шаблон маршрута
                    arguments = Routes.AppDetails.arguments  // Определение аргумента
                ) { backStackEntry ->
                    // Получаем appId из аргументов навигации
                    val appId = backStackEntry.arguments?.getString("appId") ?: ""
                    // Создаем ViewModel с передачей backStackEntry
                    val appDetailsViewModel = hiltViewModel<AppDetailsViewModel>(backStackEntry)
                    AppDetailsScreen(
                        viewModel = appDetailsViewModel,
                        onBackClick = {
                            // Переход с по кнопке "назад" на "домашний" экран со списком приложений
                            navController.navigate(Routes.Home.route)
                        },
                    )
                }
            }
        }
    }
}