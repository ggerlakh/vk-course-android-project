package com.example.vkcourseapp.domain.appdetails

import kotlinx.coroutines.flow.Flow

class ToggleWishlistAppDetailsUseCase(
    private val appDetailsRepository: AppDetailsRepository,
) {
    suspend operator fun invoke(id: String): Unit =
        appDetailsRepository.toggleWishlist(id)
}