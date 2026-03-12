package com.timzowen.apiintegrationcourse.themovieapi.data.remote

import kotlinx.serialization.Serializable

@Serializable
data class MovieResponseDto(
    val results: List<MovieDto>
)
