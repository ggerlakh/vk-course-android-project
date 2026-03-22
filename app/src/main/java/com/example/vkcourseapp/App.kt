package com.example.vkcourseapp

import android.app.Application
import dagger.hilt.android.HiltAndroidApp


@HiltAndroidApp
class App : Application() {
    override fun onCreate() {
        super.onCreate()
        android.util.Log.d("com.example.vkcourseapp", "Hilt Application initialized")
    }
}