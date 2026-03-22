package com.example.vkcourseapp.domain.appdetails

class GetAppDetailsUseCase(
    private val appDetailsRepository: AppDetailsRepository,
) {
    suspend operator fun invoke(id: String): AppDetails {
        val app: AppDetails = appDetailsRepository.get(id)

        if (app.category == Category.GAME) {
            throw IllegalStateException()
        }

        return app
    }
}