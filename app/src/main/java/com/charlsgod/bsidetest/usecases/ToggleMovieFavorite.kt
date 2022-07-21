package com.charlsgod.bsidetest.usecases

import com.charlsgod.bsidetest.domain.Movie
import com.charlsgod.bsidetest.data.repository.MoviesRepository
import javax.inject.Inject

class ToggleMovieFavorite @Inject constructor(
    private val moviesRepository: MoviesRepository
) {
    suspend fun invoke(movie: Movie): Movie = with(movie) {
        copy(favorite = !favorite).also { moviesRepository.update(it) }
    }
}