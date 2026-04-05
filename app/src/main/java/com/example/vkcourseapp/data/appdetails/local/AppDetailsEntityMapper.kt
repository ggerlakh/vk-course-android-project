package com.example.vkcourseapp.data.appdetails.local

import com.example.vkcourseapp.domain.appdetails.AppDetails
import kotlinx.serialization.json.Json

class AppDetailsEntityMapper {

    fun toEntity(domain: AppDetails): AppDetailsEntity = AppDetailsEntity(
        id = domain.id,
        name = domain.name,
        developer = domain.developer,
        category = domain.category,
        ageRating = domain.ageRating,
        size = domain.size,
        iconUrl = domain.iconUrl,
        screenshots = null,
        isInWishlist = domain.isInWishlist,
        description = domain.description
    )

    fun toDomain(entity: AppDetailsEntity): AppDetails = AppDetails(
        id = entity.id,
        name = entity.name,
        developer = entity.developer,
        category = entity.category,
        ageRating = entity.ageRating,
        size = entity.size,
        iconUrl = entity.iconUrl,
        screenshotUrlList = null,
        isInWishlist = entity.isInWishlist,
        description = entity.description
    )
}