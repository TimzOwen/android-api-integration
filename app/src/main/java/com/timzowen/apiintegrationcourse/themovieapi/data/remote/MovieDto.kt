package com.timzowen.apiintegrationcourse.themovieapi.data.remote

import kotlinx.serialization.Serializable

@Serializable
data class MovieDto(
    val id: Int,
    val title: String,
    val overview: String,
    val poster_path: String?,
)
