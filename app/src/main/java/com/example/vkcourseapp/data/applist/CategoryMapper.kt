package com.example.vkcourseapp.data.applist

import com.example.vkcourseapp.domain.applist.Category

class CategoryMapper {
    fun toDomain(category: String): Category = when (category) {
        "Финансы" -> Category.FINANCE
        "Инструменты" -> Category.TOOLS
        "Транспорт" -> Category.TRANSPORT
        else -> throw IllegalStateException("Unsupported category type $category")
    }
}