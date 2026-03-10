package com.timzowen.apiintegrationcourse.themoviedb.data.remote

import androidx.compose.ui.graphics.drawscope.Stroke
import kotlinx.serialization.Serializable


@Serializable
class MovieDto(

    val id: Int,
    val title: String,
    val overview: String,
    val poster_path: String?,

)