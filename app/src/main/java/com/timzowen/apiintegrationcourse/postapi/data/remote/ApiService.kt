package com.timzowen.apiintegrationcourse.postapi.data.remote

import com.timzowen.apiintegrationcourse.postapi.data.dto.PostDto
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

class ApiService (private val httpClient: HttpClient){
    suspend fun getPosts(): List<PostDto>{
        return httpClient.get("https://jsonplaceholder.typicode.com/posts").body()
    }

}