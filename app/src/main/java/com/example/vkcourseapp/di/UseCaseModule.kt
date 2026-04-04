package com.example.vkcourseapp.di

import com.example.vkcourseapp.domain.appdetails.AppDetailsRepository
import com.example.vkcourseapp.domain.appdetails.GetAppDetailsUseCase
import com.example.vkcourseapp.domain.appdetails.ObserveAppDetailsUseCase
import com.example.vkcourseapp.domain.appdetails.ToggleWishlistAppDetailsUseCase
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
    fun provideGetAppDetailsUseCase(
        repository: AppDetailsRepository
    ): GetAppDetailsUseCase {
        return GetAppDetailsUseCase(repository)
    }

    @Provides
    @Singleton
    fun provideObserveAppDetailsUseCase(
        repository: AppDetailsRepository
    ): ObserveAppDetailsUseCase {
        return ObserveAppDetailsUseCase(repository)
    }

    @Provides
    @Singleton
    fun provideToggleWishlistAppDetailsUseCase(
        repository: AppDetailsRepository
    ): ToggleWishlistAppDetailsUseCase {
        return ToggleWishlistAppDetailsUseCase(repository)
    }

    @Provides
    @Singleton
    fun provideGetAppListUseCase(
        repository: AppListRepository
    ): GetAppListUseCase {
        return GetAppListUseCase(repository)
    }
}