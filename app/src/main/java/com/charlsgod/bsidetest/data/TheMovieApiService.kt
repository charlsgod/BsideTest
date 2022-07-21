package com.charlsgod.bsidetest.data

import com.charlsgod.bsidetest.presentation.data.server.MovieServerResult
import retrofit2.http.GET
import retrofit2.http.Query

interface TheMovieApiService {
    @GET("discover/movie?sort_by=popularity.desc")
    suspend fun listPopularMoviesAsync(
        @Query("api_key") apiKey: String,
        @Query("region") region: String
    ): MovieServerResult
}