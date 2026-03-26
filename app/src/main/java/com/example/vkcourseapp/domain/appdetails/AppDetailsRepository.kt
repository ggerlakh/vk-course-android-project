package com.example.vkcourseapp.domain.appdetails

interface AppDetailsRepository {
    suspend fun getAppDetails(id: String): AppDetails
}