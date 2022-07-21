package com.charlsgod.bsidetest.usecases

import com.charlsgod.bsidetest.data.repository.MoviesRepository
import com.charlsgod.bsidetest.domain.Movie
import javax.inject.Inject

class FindMovieById @Inject constructor(
    private val moviesRepository: MoviesRepository
    ) {
    suspend fun invoke(id: Int): Movie = moviesRepository.findById(id)
}