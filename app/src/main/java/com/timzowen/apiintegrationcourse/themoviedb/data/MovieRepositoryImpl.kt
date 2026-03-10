package com.timzowen.apiintegrationcourse.themoviedb.data

import com.timzowen.apiintegrationcourse.themoviedb.data.mapper.toDomain
import com.timzowen.apiintegrationcourse.themoviedb.data.remote.MovieApi
import com.timzowen.apiintegrationcourse.themoviedb.domain.model.Movie
import com.timzowen.apiintegrationcourse.themoviedb.domain.repository.MovieRepository

class MovieRepositoryImpl(val movieApi: MovieApi) : MovieRepository {

    override
    suspend fun getPopularMovies(): List<Movie> {
        return movieApi.getPopularMovies().map {
            it.toDomain()
        }
    }

}