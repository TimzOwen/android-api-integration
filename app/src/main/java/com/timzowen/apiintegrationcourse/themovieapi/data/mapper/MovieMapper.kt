package com.timzowen.apiintegrationcourse.themovieapi.data.mapper

import com.timzowen.apiintegrationcourse.themovieapi.data.remote.MovieDto
import com.timzowen.apiintegrationcourse.themovieapi.domain.model.Movie
import com.timzowen.apiintegrationcourse.themovieapi.network.NetworkConstants.IMAGE_BASE


fun MovieDto.toDomain(): Movie {
    return Movie(
        id = id,
        title = title,
        overview = overview,
        posterUrl = poster_path?.let {
            IMAGE_BASE + it
        }
    )
}