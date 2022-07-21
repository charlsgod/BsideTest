package com.charlsgod.bsidetest.presentation.data.server

import com.charlsgod.bsidetest.data.TheMovieApiService
import com.charlsgod.bsidetest.data.source.RemoteDataSource
import com.charlsgod.bsidetest.domain.Movie
import com.charlsgod.bsidetest.presentation.data.toDomainMovie

class TheMovieServerDataSource(private val theMovieService: TheMovieApiService) : RemoteDataSource {

    override suspend fun getPopularMovies(apiKey: String, region: String): List<Movie> =
        theMovieService
            .listPopularMoviesAsync(apiKey, region)
            .results
            .map { it.toDomainMovie() }
}