package com.timzowen.apiintegrationcourse.postapi.data.repository

import com.timzowen.apiintegrationcourse.postapi.data.dto.toDomain
import com.timzowen.apiintegrationcourse.postapi.data.remote.ApiService
import com.timzowen.apiintegrationcourse.postapi.domain.Post

class PostRepositoryImpl(private val apiService: ApiService) : PostRepository {

    override suspend fun getAllPosts(): List<Post> {
        return apiService.getPosts().map { it.toDomain() }
    }


}