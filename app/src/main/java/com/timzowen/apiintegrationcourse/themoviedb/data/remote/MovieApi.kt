package com.timzowen.apiintegrationcourse.themoviedb.data.remote

import com.timzowen.apiintegrationcourse.themoviedb.network.NetworkConstants
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter

class MovieApi(val client: HttpClient) {

    suspend fun getPopularMovies(): List<MovieDto> {
        val response: MovieResponseDto = client
            .get("${NetworkConstants.BASE_URL}/movie/popular") {
                parameter("api_key", NetworkConstants.API_KEY)
            }
            .body()
        return response.results
    }
}