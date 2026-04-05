package com.example.vkcourseapp.data.applist

import retrofit2.http.GET

interface AppListApi {
    @GET("catalog")
    suspend fun getAppList(): List<AppItemDto>
}