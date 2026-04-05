package com.example.vkcourseapp

import com.example.vkcourseapp.domain.applist.AppListRepository
import com.example.vkcourseapp.domain.applist.AppItem
import com.example.vkcourseapp.domain.applist.GetAppListUseCase
import org.junit.Before
import org.junit.runner.RunWith
import org.junit.Test
import org.junit.Assert.assertEquals
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify
import kotlinx.coroutines.test.runTest
import org.mockito.kotlin.whenever


@RunWith(MockitoJUnitRunner::class)
class GetAppListUseCaseTest {

    private lateinit var appListRepository: AppListRepository
    private lateinit var getAppListUseCase: GetAppListUseCase

    private val initialAppList = listOf(
        AppItem(
            id = "dc290316-a07e-4d79-9f07-61456f59810c",
            name = "AstroLume",
            description = "AstroLume сочетает прогноз погоды с астрономическими данными: фазы луны, восходы и закаты, видимость планет, метеорные потоки. Планировщик для астрофотографии, уведомления о лучших условиях наблюдения, карта звездного неба. Подробные погодные данные включают влажность, давление, облачность. Идеально подходит для любителей астрономии, фотографов природы и всех, кто интересуется небом.",
            category = "Погода",
            iconUrl = "https://fastly.picsum.photos/id/264/200/200.jpg?hmac=O4sRY3iZeFvmPRuanICCCZi-CDz0HdRHMsHttvNCgmw",
        )
    )

    @Before
    fun setUp() = runTest {
        appListRepository = mock<AppListRepository>()
        whenever(appListRepository.get()).thenReturn(initialAppList)

        getAppListUseCase = GetAppListUseCase(appListRepository)
    }

    @Test
    fun `get apps EXPECT request from repository`() = runTest {
        getAppListUseCase()
        verify(appListRepository).get()
    }

    @Test
    fun `get apps EXPECT returns data from repository`() = runTest {
        val result = getAppListUseCase()

        assertEquals(initialAppList, result)
    }
}