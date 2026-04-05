package com.example.vkcourseapp.domain.applist

interface AppListRepository {
    suspend fun get(): List<AppItem>
}