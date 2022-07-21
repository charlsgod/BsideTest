package com.charlsgod.bsidetest.utils.di

import android.content.Context
import androidx.room.Room
import com.charlsgod.bsidetest.R
import com.charlsgod.bsidetest.data.source.LocalContactDataSource
import com.charlsgod.bsidetest.data.source.RemoteDataSource
import com.charlsgod.bsidetest.presentation.data.database.movies.MovieMovieDataSource
import com.charlsgod.bsidetest.presentation.data.database.contact.ContactDatabase
import com.charlsgod.bsidetest.presentation.data.database.movies.MovieDatabase
import com.charlsgod.bsidetest.presentation.data.server.TheMovieServerDataSource
import com.charlsgod.bsidetest.data.source.LocalMovieDataSource
import com.charlsgod.bsidetest.presentation.data.database.contact.ContactMovieDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Provides
    @Singleton
    fun moviesDatabaseProvider(@ApplicationContext context: Context) = Room.databaseBuilder(
        context,
        MovieDatabase::class.java,
    "movie-db"
    ).build()

    @Provides
    @Singleton
    fun contactsDatabaseProvider(@ApplicationContext context: Context) = Room.databaseBuilder(
        context,
        ContactDatabase::class.java,
        "contact-db"
    ).build()

    @Provides
    fun localContactDataSourceProvider(db: ContactDatabase): LocalContactDataSource =
        ContactMovieDataSource(db)

    @Provides
    fun localMovieDataSourceProvider(db: MovieDatabase): LocalMovieDataSource =
        MovieMovieDataSource(db)
}