package com.example.vkcourseapp.data.applist

import javax.inject.Inject
import com.example.vkcourseapp.domain.applist.AppItem
import com.example.vkcourseapp.domain.applist.AppListRepository

class AppListRepositoryImpl @Inject constructor(
    private val mapper: AppItemMapper,
    private val api: AppListApi
) : AppListRepository {
    override suspend fun get(): List<AppItem> {
        val appsDto = api.get()
        val appsDomain = appsDto.map { appItemDto ->
            mapper.toDomain(appItemDto)
        }
        return appsDomain
    }
}