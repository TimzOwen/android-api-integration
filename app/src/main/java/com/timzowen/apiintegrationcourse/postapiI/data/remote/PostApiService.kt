package com.timzowen.apiintegrationcourse.postapiI.data.remote

import com.timzowen.apiintegrationcourse.postapiI.data.remote.dto.PostDto
import com.timzowen.apiintegrationcourse.postapiI.domain.model.Post
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.http.ContentType
import io.ktor.http.contentType

class PostApiService(val client: HttpClient) {

    suspend fun getPosts(): List<PostDto> {
        return client
            .get("https://jsonplaceholder.typicode.com/posts")
            .body()
    }

    suspend fun createPost(postDto: PostDto): PostDto {
        return client.post("https://jsonplaceholder.typicode.com/posts") {
            contentType(ContentType.Application.Json)
            setBody(postDto)
        }.body()
    }
}