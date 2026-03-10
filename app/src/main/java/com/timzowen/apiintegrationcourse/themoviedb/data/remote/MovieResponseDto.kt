package com.timzowen.apiintegrationcourse.themoviedb.data.remote

import kotlinx.serialization.Serializable

@Serializable
class MovieResponseDto(
    val results: List<MovieDto>
)