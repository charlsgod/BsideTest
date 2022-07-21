package com.charlsgod.bsidetest.utils.di

import android.content.Context
import com.charlsgod.bsidetest.R
import com.charlsgod.bsidetest.data.TheMovieApiService
import com.charlsgod.bsidetest.data.source.RemoteDataSource
import com.charlsgod.bsidetest.presentation.data.server.TheMovieServerDataSource
import com.charlsgod.bsidetest.utils.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {


    @Provides
    @Singleton
    @Named("apiKey")
    fun apiKeyProvider(@ApplicationContext context: Context): String =
        context.getString(R.string.api_key)


    @Provides
    @Singleton
    fun provideHeaderInterceptor(): Interceptor {
        return Interceptor {
            val requestBuilder = it.request().newBuilder()
            //hear you can add all headers you want by calling 'requestBuilder.addHeader(name ,  value)'
            it.proceed(requestBuilder.build())
        }
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(
        headerInterceptor: Interceptor,
    ): OkHttpClient {

        val okHttpClientBuilder = OkHttpClient().newBuilder()
        okHttpClientBuilder.addInterceptor(headerInterceptor)

        return okHttpClientBuilder.build()
    }

    @Provides
    @Singleton
    fun provideMovieApiService(client: OkHttpClient): TheMovieApiService = Retrofit.Builder()
        .baseUrl(Constants.BASE_URL)
        .client(client)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .run { create(TheMovieApiService::class.java) }

    @Provides
    fun remoteDataSourceProvider(theMovieService: TheMovieApiService): RemoteDataSource =
        TheMovieServerDataSource(theMovieService)
}