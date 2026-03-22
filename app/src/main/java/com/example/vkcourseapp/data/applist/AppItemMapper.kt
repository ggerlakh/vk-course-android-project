package com.example.vkcourseapp.data.applist

import com.example.vkcourseapp.domain.applist.AppItem
import javax.inject.Inject

class AppItemMapper @Inject constructor(
    private val categoryMapper: CategoryMapper
) {
    fun toDomain(dto: AppItemDto): AppItem = AppItem(
        iconResId = dto.id,
        name = dto.name,
        description = dto.description,
        category = categoryMapper.toDomain(dto.category)
    )
}