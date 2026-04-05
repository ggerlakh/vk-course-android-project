package com.example.vkcourseapp

import com.example.vkcourseapp.data.appdetails.local.AppDetailsEntity
import com.example.vkcourseapp.data.appdetails.local.AppDetailsEntityMapper
import com.example.vkcourseapp.domain.appdetails.AppDetails
import com.example.vkcourseapp.domain.appdetails.Category
import org.junit.Before
import org.junit.Test
import org.junit.Assert.assertEquals

class AppDetailsEntityMapperTest {

    private lateinit var mapper: AppDetailsEntityMapper

    @Before
    fun setUp() {
        mapper = AppDetailsEntityMapper()
    }

    @Test
    fun `toDomain EXPECT map all fields correctly`() {
        val dto = AppDetailsEntity(
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

        val domain = mapper.toDomain(dto)

        assertEquals(dto.id, domain.id)
        assertEquals(dto.name, domain.name)
        assertEquals(dto.developer, domain.developer)
        assertEquals(dto.category, domain.category)
        assertEquals(dto.ageRating, domain.ageRating)
        assertEquals(dto.size, domain.size)
        assertEquals(dto.iconUrl, domain.iconUrl)
        assertEquals(dto.isInWishlist, domain.isInWishlist)
        assertEquals(dto.description, domain.description)
    }

    @Test
    fun `toDto EXPECT map all fields correctly`() {
        val domain = AppDetails(
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

        val dto = mapper.toEntity(domain)

        assertEquals(domain.id, dto.id)
        assertEquals(domain.name, dto.name)
        assertEquals(domain.developer, dto.developer)
        assertEquals(domain.category, dto.category)
        assertEquals(domain.ageRating, dto.ageRating)
        assertEquals(domain.size, dto.size)
        assertEquals(domain.iconUrl, dto.iconUrl)
        assertEquals(domain.isInWishlist, dto.isInWishlist)
        assertEquals(domain.description, dto.description)
    }

    @Test
    fun `toDomain, toDto EXPECT originalDto`() {
        val originalDto = AppDetailsEntity(
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

        val domain = mapper.toDomain(originalDto)
        val restoredDto = mapper.toEntity(domain)

        assertEquals(originalDto, restoredDto)
    }

    @Test
    fun `toDto, toDomain EXPECT originalDomain`() {
        val originalDomain = AppDetails(
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

        val dto = mapper.toEntity(originalDomain)
        val restoredDomain = mapper.toDomain(dto)

        assertEquals(originalDomain, restoredDomain)
    }

    @Test
    fun `toDto with domain without isInWishList EXPECT default value for isInWishList`() {
        val domain = AppDetails(
            id = "cbd17df3-22d2-4c63-b0ff-27ce317ed2c4",
            name = "SmartCart",
            developer = "SmartCart Solutions",
            category = Category.SHOPPING,
            ageRating = 3,
            size = 16.2f,
            iconUrl = "https://fastly.picsum.photos/id/274/200/200.jpg?hmac=VyAAGiz9gpzTWWiY_4gc4fekD4gYiGiDHvS2XePRv8I",
            screenshotUrlList = null,
            description = "SmartCart оптимизирует покупки в супермаркетах: сравнение цен, уведомления о скидках, карта расположения товаров в магазине. Сканирование штрих-кодов, история покупок, анализ трат по категориям. Список покупок с автоматическими предложениями, купоны и промокоды, кэшбэк программы. Семейные списки, напоминания о заканчивающихся продуктах, интеграция с программами лояльности магазинов.",
        )

        val dto = mapper.toEntity(domain)
        assertEquals(false, dto.isInWishlist)
        assertEquals(domain.isInWishlist, dto.isInWishlist)
    }
}