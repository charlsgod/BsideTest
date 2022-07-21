package com.charlsgod.bsidetest.presentation.data

import com.charlsgod.bsidetest.domain.Movie
import com.charlsgod.bsidetest.presentation.data.database.movies.Movie as DbMovie
import com.charlsgod.bsidetest.presentation.data.server.Movie as ServerMovie
import com.charlsgod.bsidetest.domain.Contact
import com.charlsgod.bsidetest.presentation.data.database.contact.Contact as DbContact

fun Movie.toDbMovie(): DbMovie =
    DbMovie(
        id,
        title,
        overview,
        releaseDate,
        posterPath,
        backdropPath,
        originalLanguage,
        originalTitle,
        popularity,
        voteAverage,
        favorite
    )

fun DbMovie.toDomainMovie(): Movie =
    Movie(
        id,
        title,
        overview,
        releaseDate,
        posterPath,
        backdropPath,
        originalLanguage,
        originalTitle,
        popularity,
        voteAverage,
        favorite
    )

fun ServerMovie.toDomainMovie(): Movie =
    Movie(
        0,
        title,
        overview,
        releaseDate,
        posterPath,
        backdropPath ?: posterPath,
        originalLanguage,
        originalTitle,
        popularity,
        voteAverage,
        false
    )

fun Contact.toDbContact(): DbContact =
    DbContact(
        id,
        name,
        lastNames,
        phoneNumber,
        address,
        email,
        favorite
    )

fun DbContact.toDomainContact(): Contact =
    Contact(
        id,
        name,
        lastNames,
        phoneNumber,
        address,
        email,
        favorite
    )