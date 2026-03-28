package com.example.vkcourseapp.data.appdetails

import com.example.vkcourseapp.domain.appdetails.AppDetails
import com.example.vkcourseapp.domain.appdetails.AppDetailsRepository
import javax.inject.Inject

class AppDetailsRepositoryImpl @Inject constructor(
    private val appApi: AppApi,
) : AppDetailsRepository {
    private val mapper = AppDetailsMapper()

    override suspend fun getAppDetails(id: String): AppDetails {
        val dto = appApi.getAppDetails(id)
        val domain = mapper.toDomain(dto)
        return domain
    }
}