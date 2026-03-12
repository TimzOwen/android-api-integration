package com.timzowen.apiintegrationcourse.themovieapi.data.repository

import com.timzowen.apiintegrationcourse.themovieapi.data.MovieApiService
import com.timzowen.apiintegrationcourse.themovieapi.data.mapper.toDomain
import com.timzowen.apiintegrationcourse.themovieapi.domain.model.Movie
import com.timzowen.apiintegrationcourse.themovieapi.domain.repository.MovieApiRepository

class MovieRepoImpl(val movieApiService: MovieApiService) : MovieApiRepository {

    override suspend fun getTrendingMovies(): List<Movie> {
        return movieApiService.getPopularMovies().map {
            it.toDomain()
        }
    }

}