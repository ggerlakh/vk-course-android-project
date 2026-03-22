package com.example.vkcourseapp.di

import com.example.vkcourseapp.domain.applist.AppListRepository
import com.example.vkcourseapp.domain.applist.GetAppListUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    @Singleton
    fun provideGetAppListUseCase(
        repository: AppListRepository
    ): GetAppListUseCase {
        return GetAppListUseCase(repository)
    }
}