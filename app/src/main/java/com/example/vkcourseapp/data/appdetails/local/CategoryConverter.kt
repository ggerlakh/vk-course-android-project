package com.example.vkcourseapp.data.appdetails.local

import androidx.room.TypeConverter
import com.example.vkcourseapp.domain.appdetails.Category

class CategoryConverter {
    @TypeConverter
    fun fromCategory(category: Category): String = category.name

    @TypeConverter
    fun toCategory(categoryName: String): Category = Category.valueOf(categoryName)
}