package com.charlsgod.bsidetest.data.source

import com.charlsgod.bsidetest.domain.Movie

interface RemoteDataSource {
    suspend fun getPopularMovies(apiKey: String, region: String): List<Movie>
}