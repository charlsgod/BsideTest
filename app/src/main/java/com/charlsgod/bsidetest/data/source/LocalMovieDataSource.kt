package com.charlsgod.bsidetest.data.source

import com.charlsgod.bsidetest.domain.Movie

interface LocalMovieDataSource {
    suspend fun isEmpty(): Boolean
    suspend fun saveMovies(movies: List<Movie>)
    suspend fun getPopularMovies(): List<Movie>
    suspend fun findById(id: Int): Movie
    suspend fun update(movie: Movie)
}