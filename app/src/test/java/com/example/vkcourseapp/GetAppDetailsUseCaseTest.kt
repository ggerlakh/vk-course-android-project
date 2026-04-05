package com.example.vkcourseapp

import com.example.vkcourseapp.domain.appdetails.AppDetails
import com.example.vkcourseapp.domain.appdetails.AppDetailsRepository
import com.example.vkcourseapp.domain.appdetails.Category
import com.example.vkcourseapp.domain.appdetails.GetAppDetailsUseCase
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify
import org.mockito.kotlin.whenever

@RunWith(MockitoJUnitRunner::class)
class GetAppDetailsUseCaseTest {

    private lateinit var appDetailsRepository: AppDetailsRepository
    private lateinit var getAppDetailsUseCase: GetAppDetailsUseCase

    private val firstApp = AppDetails(
            id = "dc290316-a07e-4d79-9f07-61456f59810c",
            name = "AstroLume",
            developer = "AstroApps",
            category = Category.WEATHER,
            ageRating = 3,
            size = 16.4f,
            iconUrl = "https://fastly.picsum.photos/id/264/200/200.jpg?hmac=O4sRY3iZeFvmPRuanICCCZi-CDz0HdRHMsHttvNCgmw",
            screenshotUrlList = listOf(
                "https://fastly.picsum.photos/id/42/200/200.jpg?hmac=jc_eDuYgXmIOC_4gl2wEY0jgxC2rMPJbDF6QJdynR7Q",
                "https://fastly.picsum.photos/id/43/200/200.jpg?hmac=gMoEYpdjrHoRnKoyIdtTknuqyCQDTC8exwLaKHpMv6E",
                "https://fastly.picsum.photos/id/44/200/200.jpg?hmac=W5KcqhapHjBgEIHGQpQnX6o9jdOXQEVCKEdGIohjisY",
                "https://fastly.picsum.photos/id/45/200/200.jpg?hmac=D9U6XUZsrWfv7UlIM9gKYtENGZ6jeG3H6qGxMT5gxsY",
                "https://fastly.picsum.photos/id/46/200/200.jpg?hmac=lUGWM3WNJB0TQ-OXq3KI1x-TPgKIuViXG4lKHiCGbao"
            ),
            description = "AstroLume сочетает прогноз погоды с астрономическими данными: фазы луны, восходы и закаты, видимость планет, метеорные потоки. Планировщик для астрофотографии, уведомления о лучших условиях наблюдения, карта звездного неба. Подробные погодные данные включают влажность, давление, облачность. Идеально подходит для любителей астрономии, фотографов природы и всех, кто интересуется небом.",
        )

    private val secondApp = AppDetails(
            id = "cbd17df3-22d2-4c63-b0ff-27ce317ed2c4",
            name = "SmartCart",
            developer = "SmartCart Solutions",
            category = Category.SHOPPING,
            ageRating = 3,
            size = 16.2f,
            iconUrl = "https://fastly.picsum.photos/id/274/200/200.jpg?hmac=VyAAGiz9gpzTWWiY_4gc4fekD4gYiGiDHvS2XePRv8I",
            screenshotUrlList = listOf(
                "https://fastly.picsum.photos/id/42/200/200.jpg?hmac=jc_eDuYgXmIOC_4gl2wEY0jgxC2rMPJbDF6QJdynR7Q",
                "https://fastly.picsum.photos/id/43/200/200.jpg?hmac=gMoEYpdjrHoRnKoyIdtTknuqyCQDTC8exwLaKHpMv6E",
                "https://fastly.picsum.photos/id/44/200/200.jpg?hmac=W5KcqhapHjBgEIHGQpQnX6o9jdOXQEVCKEdGIohjisY",
                "https://fastly.picsum.photos/id/45/200/200.jpg?hmac=D9U6XUZsrWfv7UlIM9gKYtENGZ6jeG3H6qGxMT5gxsY",
                "https://fastly.picsum.photos/id/46/200/200.jpg?hmac=lUGWM3WNJB0TQ-OXq3KI1x-TPgKIuViXG4lKHiCGbao"
            ),
            description = "SmartCart оптимизирует покупки в супермаркетах: сравнение цен, уведомления о скидках, карта расположения товаров в магазине. Сканирование штрих-кодов, история покупок, анализ трат по категориям. Список покупок с автоматическими предложениями, купоны и промокоды, кэшбэк программы. Семейные списки, напоминания о заканчивающихся продуктах, интеграция с программами лояльности магазинов.",
        )


    @Test
    fun `get first app EXPECT request from repository`() = runTest {
        appDetailsRepository = mock<AppDetailsRepository>()
        whenever(appDetailsRepository.getAppDetails("dc290316-a07e-4d79-9f07-61456f59810c")).thenReturn(firstApp)

        getAppDetailsUseCase = GetAppDetailsUseCase(appDetailsRepository)

        getAppDetailsUseCase("dc290316-a07e-4d79-9f07-61456f59810c")
        verify(appDetailsRepository).getAppDetails("dc290316-a07e-4d79-9f07-61456f59810c")
    }

    @Test
    fun `get first app EXPECT returns data from repository`() = runTest {
        appDetailsRepository = mock<AppDetailsRepository>()
        whenever(appDetailsRepository.getAppDetails("dc290316-a07e-4d79-9f07-61456f59810c")).thenReturn(firstApp)

        getAppDetailsUseCase = GetAppDetailsUseCase(appDetailsRepository)

        val result = getAppDetailsUseCase("dc290316-a07e-4d79-9f07-61456f59810c")

        assertEquals(firstApp, result)
    }

    @Test
    fun `get second app EXPECT returns data from repository`() = runTest {
        appDetailsRepository = mock<AppDetailsRepository>()
        whenever(appDetailsRepository.getAppDetails("cbd17df3-22d2-4c63-b0ff-27ce317ed2c4")).thenReturn(secondApp)

        getAppDetailsUseCase = GetAppDetailsUseCase(appDetailsRepository)

        val result = getAppDetailsUseCase("cbd17df3-22d2-4c63-b0ff-27ce317ed2c4")

        assertEquals(secondApp, result)
    }
}