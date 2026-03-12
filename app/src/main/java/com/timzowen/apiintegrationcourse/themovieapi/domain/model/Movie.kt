package com.timzowen.apiintegrationcourse.themovieapi.domain.model

data class Movie(
    val id: Int = 0,
    val title: String,
    val overview: String,
    val posterUrl: String?,
)