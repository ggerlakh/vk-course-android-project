package com.example.vkcourseapp

import com.example.vkcourseapp.data.appdetails.AppApi
import com.example.vkcourseapp.data.appdetails.AppDetailsMapper
import com.example.vkcourseapp.data.appdetails.local.AppDetailsDao
import com.example.vkcourseapp.data.appdetails.local.AppDetailsEntity
import com.example.vkcourseapp.data.appdetails.AppDetailsDto
import com.example.vkcourseapp.data.appdetails.AppDetailsRepositoryImpl
import com.example.vkcourseapp.data.appdetails.local.AppDetailsEntityMapper
import com.example.vkcourseapp.domain.appdetails.AppDetails
import com.example.vkcourseapp.domain.appdetails.Category
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.doNothing
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify
import org.mockito.kotlin.whenever

@RunWith(MockitoJUnitRunner::class)
class AppDetailsRepositoryImplTest {

    private lateinit var mapper: AppDetailsMapper
    private lateinit var appApi: AppApi
    private lateinit var dao: AppDetailsDao
    private lateinit var entityMapper: AppDetailsEntityMapper

    private val initialAppEntity = AppDetailsEntity(
        id = "cbd17df3-22d2-4c63-b0ff-27ce317ed2c4",
        name = "SmartCart",
        developer = "SmartCart Solutions",
        category = Category.SHOPPING,
        ageRating = 3,
        size = 16.2f,
        iconUrl = "https://fastly.picsum.photos/id/274/200/200.jpg?hmac=VyAAGiz9gpzTWWiY_4gc4fekD4gYiGiDHvS2XePRv8I",
        screenshots = null,
        isInWishlist = false,
        description = "SmartCart оптимизирует покупки в супермаркетах: сравнение цен, уведомления о скидках, карта расположения товаров в магазине. Сканирование штрих-кодов, история покупок, анализ трат по категориям. Список покупок с автоматическими предложениями, купоны и промокоды, кэшбэк программы. Семейные списки, напоминания о заканчивающихся продуктах, интеграция с программами лояльности магазинов.",
    )

    private val initialAppDto = AppDetailsDto(
        id = "cbd17df3-22d2-4c63-b0ff-27ce317ed2c4",
        name = "SmartCart",
        developer = "SmartCart Solutions",
        category = Category.SHOPPING,
        ageRating = 3,
        size = 16.2,
        icon = "https://fastly.picsum.photos/id/274/200/200.jpg?hmac=VyAAGiz9gpzTWWiY_4gc4fekD4gYiGiDHvS2XePRv8I",
        screenshots = null,
        description = "SmartCart оптимизирует покупки в супермаркетах: сравнение цен, уведомления о скидках, карта расположения товаров в магазине. Сканирование штрих-кодов, история покупок, анализ трат по категориям. Список покупок с автоматическими предложениями, купоны и промокоды, кэшбэк программы. Семейные списки, напоминания о заканчивающихся продуктах, интеграция с программами лояльности магазинов.",
    )

    private val initialAppDomain = AppDetails(
        id = "cbd17df3-22d2-4c63-b0ff-27ce317ed2c4",
        name = "SmartCart",
        developer = "SmartCart Solutions",
        category = Category.SHOPPING,
        ageRating = 3,
        size = 16.2f,
        iconUrl = "https://fastly.picsum.photos/id/274/200/200.jpg?hmac=VyAAGiz9gpzTWWiY_4gc4fekD4gYiGiDHvS2XePRv8I",
        screenshotUrlList = null,
        isInWishlist = false,
        description = "SmartCart оптимизирует покупки в супермаркетах: сравнение цен, уведомления о скидках, карта расположения товаров в магазине. Сканирование штрих-кодов, история покупок, анализ трат по категориям. Список покупок с автоматическими предложениями, купоны и промокоды, кэшбэк программы. Семейные списки, напоминания о заканчивающихся продуктах, интеграция с программами лояльности магазинов.",
    )

    @Before
    fun setUp() {
        mapper = mock<AppDetailsMapper>()
        appApi = mock<AppApi>()
        dao = mock<AppDetailsDao>()
        entityMapper = mock<AppDetailsEntityMapper>()

        whenever(mapper.toDomain(initialAppDto)).thenReturn(initialAppDomain)
        whenever(entityMapper.toEntity(initialAppDomain)).thenReturn(initialAppEntity)
        whenever(entityMapper.toDomain(initialAppEntity)).thenReturn(initialAppDomain)
        doNothing().whenever(dao).insertAppDetails(initialAppEntity)
    }

    @Test
    fun `get app when cache miss EXPECT request from appApi`() = runTest {
        whenever(dao.getAppDetails("cbd17df3-22d2-4c63-b0ff-27ce317ed2c4")).thenReturn(listOf(null).asFlow())
        whenever(appApi.getAppDetails("cbd17df3-22d2-4c63-b0ff-27ce317ed2c4")).thenReturn(initialAppDto)

        val appDetailsRepositoryImpl = AppDetailsRepositoryImpl(
            appApi = appApi,
            dao = dao,
            mapper = mapper,
            entityMapper = entityMapper
        )

        appDetailsRepositoryImpl.getAppDetails("cbd17df3-22d2-4c63-b0ff-27ce317ed2c4")

        verify(appApi).getAppDetails("cbd17df3-22d2-4c63-b0ff-27ce317ed2c4")
    }

    @Test
    fun `get app when cache miss EXPECT returns data from appApi`() = runTest {
        whenever(dao.getAppDetails("cbd17df3-22d2-4c63-b0ff-27ce317ed2c4")).thenReturn(listOf(null).asFlow())
        whenever(appApi.getAppDetails("cbd17df3-22d2-4c63-b0ff-27ce317ed2c4")).thenReturn(initialAppDto)

        val appDetailsRepositoryImpl = AppDetailsRepositoryImpl(
            appApi = appApi,
            dao = dao,
            mapper = mapper,
            entityMapper = entityMapper
        )

        val result = appDetailsRepositoryImpl.getAppDetails("cbd17df3-22d2-4c63-b0ff-27ce317ed2c4")

        assertEquals(initialAppDomain, result)
    }

    @Test
    fun `get app when cache miss EXPECT request from dao for cache update`() = runTest {
        whenever(dao.getAppDetails("cbd17df3-22d2-4c63-b0ff-27ce317ed2c4")).thenReturn(listOf(null).asFlow())
        whenever(appApi.getAppDetails("cbd17df3-22d2-4c63-b0ff-27ce317ed2c4")).thenReturn(initialAppDto)

        val appDetailsRepositoryImpl = AppDetailsRepositoryImpl(
            appApi = appApi,
            dao = dao,
            mapper = mapper,
            entityMapper = entityMapper
        )

        appDetailsRepositoryImpl.getAppDetails("cbd17df3-22d2-4c63-b0ff-27ce317ed2c4")

        verify(dao).insertAppDetails(initialAppEntity)
    }

    @Test
    fun `get app when cache hit EXPECT request from dao`() = runTest {
        whenever(dao.getAppDetails("cbd17df3-22d2-4c63-b0ff-27ce317ed2c4")).thenReturn(listOf(initialAppEntity).asFlow())

        val appDetailsRepositoryImpl = AppDetailsRepositoryImpl(
            appApi = appApi,
            dao = dao,
            mapper = mapper,
            entityMapper = entityMapper
        )

        appDetailsRepositoryImpl.getAppDetails("cbd17df3-22d2-4c63-b0ff-27ce317ed2c4")

        verify(entityMapper).toDomain(initialAppEntity)
    }

    @Test
    fun `get app when cache hit EXPECT returns data from dao`() = runTest {
        whenever(dao.getAppDetails("cbd17df3-22d2-4c63-b0ff-27ce317ed2c4")).thenReturn(listOf(initialAppEntity).asFlow())

        val appDetailsRepositoryImpl = AppDetailsRepositoryImpl(
            appApi = appApi,
            dao = dao,
            mapper = mapper,
            entityMapper = entityMapper
        )

        val result = appDetailsRepositoryImpl.getAppDetails("cbd17df3-22d2-4c63-b0ff-27ce317ed2c4")

        assertEquals(initialAppDomain, result)
    }
}