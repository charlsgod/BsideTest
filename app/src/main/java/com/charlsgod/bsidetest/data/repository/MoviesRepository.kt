package com.charlsgod.bsidetest.data.repository

import com.charlsgod.bsidetest.domain.Movie
import com.charlsgod.bsidetest.data.source.LocalMovieDataSource
import com.charlsgod.bsidetest.data.source.RemoteDataSource

class MoviesRepository(
    private val localMovieDataSource: LocalMovieDataSource,
    private val remoteDataSource: RemoteDataSource,
    private val apiKey: String
) {

    suspend fun getPopularMovies(): List<Movie> {

        if (localMovieDataSource.isEmpty()) {
            //TODO: Implement location service
            val movies =
                remoteDataSource.getPopularMovies(apiKey, "mx")
            localMovieDataSource.saveMovies(movies)
        }

        return localMovieDataSource.getPopularMovies()
    }

    suspend fun findById(id: Int): Movie = localMovieDataSource.findById(id)

    suspend fun update(movie: Movie) = localMovieDataSource.update(movie)
}