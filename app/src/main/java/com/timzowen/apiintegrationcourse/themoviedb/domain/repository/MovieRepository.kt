package com.timzowen.apiintegrationcourse.themoviedb.domain.repository

import com.timzowen.apiintegrationcourse.themoviedb.domain.model.Movie


interface MovieRepository {

    suspend fun getPopularMovies(): List<Movie>

}