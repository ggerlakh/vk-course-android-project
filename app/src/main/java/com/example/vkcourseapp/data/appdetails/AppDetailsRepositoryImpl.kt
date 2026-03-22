package com.example.vkcourseapp.data.appdetails

import com.example.vkcourseapp.domain.appdetails.AppDetails
import com.example.vkcourseapp.domain.appdetails.AppDetailsRepository

class AppDetailsRepositoryImpl : AppDetailsRepository {
    private val appApi = AppApi()
    private val mapper = AppDetailsMapper()

    override suspend fun get(id: String): AppDetails {
        val dto = appApi.get(id)
        val domain = mapper.toDomain(dto)
        return domain
    }
}