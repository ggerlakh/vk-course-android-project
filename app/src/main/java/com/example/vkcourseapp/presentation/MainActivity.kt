package com.example.vkcourseapp.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.vkcourseapp.presentation.navigation.App
import com.example.vkcourseapp.presentation.theme.VkCourseAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            VkCourseAppTheme {
                App()
            }
        }
    }
}