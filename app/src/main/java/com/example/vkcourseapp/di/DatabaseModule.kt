package com.example.vkcourseapp.di

import com.example.vkcourseapp.data.appdetails.AppApi
import com.example.vkcourseapp.data.appdetails.AppDetailsMapper
import com.example.vkcourseapp.data.appdetails.AppDetailsRepositoryImpl
import com.example.vkcourseapp.data.appdetails.local.AppDatabase
import com.example.vkcourseapp.data.appdetails.local.AppDetailsDao
import com.example.vkcourseapp.data.appdetails.local.AppDetailsEntityMapper
import com.example.vkcourseapp.domain.appdetails.AppDetailsRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import android.app.Application
import androidx.room.Room

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Provides
    @Singleton
    fun provideDatabase(app: Application): AppDatabase {
        return Room.databaseBuilder(
            app,
            AppDatabase::class.java,
            AppDatabase.DATABASE_NAME
        )
            .fallbackToDestructiveMigration(false)
            .build()
    }

    @Provides
    @Singleton
    fun provideAppDetailsDao(database: AppDatabase): AppDetailsDao {
        return database.appDetailsDao()
    }

    @Provides
    @Singleton
    fun provideAppDetailsEntityMapper(): AppDetailsEntityMapper {
        return AppDetailsEntityMapper()
    }

    @Provides
    @Singleton
    fun provideAppDetailsMapper(): AppDetailsMapper {
        return AppDetailsMapper()
    }
}