package com.example.vkcourseapp.data.appdetails

import com.example.vkcourseapp.data.appdetails.local.AppDetailsDao
import com.example.vkcourseapp.data.appdetails.local.AppDetailsEntityMapper
import com.example.vkcourseapp.domain.appdetails.AppDetails
import com.example.vkcourseapp.domain.appdetails.AppDetailsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.withContext
import javax.inject.Inject

class AppDetailsRepositoryImpl @Inject constructor(
    private val appApi: AppApi,
    private val dao: AppDetailsDao,
    private val mapper: AppDetailsMapper,
    private val entityMapper: AppDetailsEntityMapper,
) : AppDetailsRepository {

    override suspend fun getAppDetails(id: String): AppDetails {
        val entity = dao.getAppDetails(id).first()
        return if (entity != null) {
            entityMapper.toDomain(entity)
        } else {
            val dto = appApi.getAppDetails(id)
            val domain = mapper.toDomain(dto)
            val entity = entityMapper.toEntity(domain)
            withContext(Dispatchers.IO) {
                dao.insertAppDetails(entity)
            }
            domain
        }
    }
}
