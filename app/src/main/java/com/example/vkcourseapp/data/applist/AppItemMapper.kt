package com.example.vkcourseapp.data.applist

import com.example.vkcourseapp.domain.applist.AppItem
import javax.inject.Inject

class AppItemMapper @Inject constructor() {
    fun toDomain(dto: AppItemDto): AppItem = AppItem(
        id = dto.id,
        name = dto.name,
        description = dto.description,
        category = dto.category,
        iconUrl = dto.iconUrl,
    )
}