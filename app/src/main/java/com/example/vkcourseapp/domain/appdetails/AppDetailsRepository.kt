package com.example.vkcourseapp.domain.appdetails

interface AppDetailsRepository {
    suspend fun get(id: String): AppDetails
}