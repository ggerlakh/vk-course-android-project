package com.example.vkcourseapp.di

import com.example.vkcourseapp.data.applist.AppListRepositoryImpl
import com.example.vkcourseapp.domain.applist.AppListRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    abstract fun bindAppListRepository(impl: AppListRepositoryImpl): AppListRepository
}