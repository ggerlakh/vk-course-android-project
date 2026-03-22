package com.example.vkcourseapp.domain.applist

class GetAppListUseCase(
    private val appListRepository: AppListRepository
) {
    suspend operator fun invoke(): List<AppItem> {
        val apps: List<AppItem> = appListRepository.get()

        if (apps.isEmpty()) {
            throw IllegalStateException()
        }

        return apps
    }
}