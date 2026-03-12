package com.timzowen.apiintegrationcourse.themovieapi.data

import com.timzowen.apiintegrationcourse.themovieapi.data.remote.MovieDto
import com.timzowen.apiintegrationcourse.themovieapi.data.remote.MovieResponseDto
import com.timzowen.apiintegrationcourse.themovieapi.network.NetworkConstants
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter

class MovieApiService(val httpClient: HttpClient) {

    suspend fun getPopularMovies(): List<MovieDto> {
        val response: MovieResponseDto = httpClient
            .get("${NetworkConstants.BASE_URL}/movie/popular") {
                parameter("api_key", NetworkConstants.API_KEY)
            }.body()
        return response.results
    }
}