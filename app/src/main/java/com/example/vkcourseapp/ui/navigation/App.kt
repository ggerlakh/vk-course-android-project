package com.example.vkcourseapp.ui.navigation

import androidx.compose.foundation.layout.padding
import androidx.navigation.compose.rememberNavController
import com.example.vkcourseapp.ui.theme.VkCourseAppTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import com.example.vkcourseapp.ui.applist.AppListScreen
import com.example.vkcourseapp.ui.appdetails.AppDetailsScreen
import androidx.navigation.compose.composable

sealed class Routes(val route: String) {

    object Home : Routes("home")
    object AppDetails : Routes("app_details")
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
                composable(Routes.Home.route) {
                    /*
                    Передаем лямбду для перехода с домашнего экрана со списком приложений
                    для перехода на экран с карточкой из практики по клику на AppItem
                    */
                    AppListScreen(onAppClick = { navController.navigate(Routes.AppDetails.route) })
                }

                composable(Routes.AppDetails.route) {
                    AppDetailsScreen()
                }
            }
        }
    }
}