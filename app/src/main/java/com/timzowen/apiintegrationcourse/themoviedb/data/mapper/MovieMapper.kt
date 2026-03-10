package com.timzowen.apiintegrationcourse.themoviedb.data.mapper

import com.timzowen.apiintegrationcourse.themoviedb.data.remote.MovieDto
import com.timzowen.apiintegrationcourse.themoviedb.domain.model.Movie
import com.timzowen.apiintegrationcourse.themoviedb.network.NetworkConstants


fun Movie.toDto(): MovieDto {
    return MovieDto(
        id = id,
        title = title,
        overview = overview,
        poster_path = posterUrl
    )
}

fun MovieDto.toDomain(): Movie {
    return Movie(
        id = id,
        title = title,
        overview = overview,
        posterUrl = poster_path?.let {
            NetworkConstants.IMAGE_BASE + it
        }
    )
}