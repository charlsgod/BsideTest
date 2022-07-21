package com.charlsgod.bsidetest.usecases

import com.charlsgod.bsidetest.data.repository.MoviesRepository
import com.charlsgod.bsidetest.domain.Movie
import javax.inject.Inject

class GetPopularMovies @Inject constructor(
    private val moviesRepository: MoviesRepository
) {
    suspend fun invoke(): List<Movie> = moviesRepository.getPopularMovies()
}