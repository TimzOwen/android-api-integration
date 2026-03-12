package com.timzowen.apiintegrationcourse.themovieapi.domain.repository

import com.timzowen.apiintegrationcourse.themovieapi.domain.model.Movie

interface MovieApiRepository {

    suspend fun getTrendingMovies(): List<Movie>

}