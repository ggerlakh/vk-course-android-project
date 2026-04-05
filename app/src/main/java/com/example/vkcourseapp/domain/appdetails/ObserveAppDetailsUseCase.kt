package com.example.vkcourseapp.domain.appdetails

import kotlinx.coroutines.flow.Flow

class ObserveAppDetailsUseCase(
    private val appDetailsRepository: AppDetailsRepository,
) {
    operator fun invoke(id: String): Flow<AppDetails> =
        appDetailsRepository.observeAppDetails(id)
}