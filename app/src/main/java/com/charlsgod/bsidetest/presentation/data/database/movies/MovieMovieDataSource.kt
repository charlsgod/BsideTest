package com.charlsgod.bsidetest.presentation.data.database.movies

import com.charlsgod.bsidetest.data.source.LocalMovieDataSource
import com.charlsgod.bsidetest.domain.Movie
import com.charlsgod.bsidetest.presentation.data.toDbMovie
import com.charlsgod.bsidetest.presentation.data.toDomainMovie
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MovieMovieDataSource(db: MovieDatabase) : LocalMovieDataSource {

    private val movieDao = db.movieDao()

    override suspend fun isEmpty(): Boolean =
        withContext(Dispatchers.IO) { movieDao.movieCount() <= 0 }

    override suspend fun saveMovies(movies: List<Movie>) {
        withContext(Dispatchers.IO) { movieDao.insertMovies(movies.map { it.toDbMovie() }) }
    }

    override suspend fun getPopularMovies(): List<Movie> = withContext(Dispatchers.IO) {
        movieDao.getAll().map { it.toDomainMovie() }
    }

    override suspend fun findById(id: Int): Movie = withContext(Dispatchers.IO) {
        movieDao.findById(id).toDomainMovie()
    }

    override suspend fun update(movie: Movie) {
        withContext(Dispatchers.IO) { movieDao.updateMovie(movie.toDbMovie()) }
    }
}