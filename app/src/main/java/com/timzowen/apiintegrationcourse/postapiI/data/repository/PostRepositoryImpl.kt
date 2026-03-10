package com.timzowen.apiintegrationcourse.postapiI.data.repository

import com.timzowen.apiintegrationcourse.postapi.data.dto.toDomain
import com.timzowen.apiintegrationcourse.postapiI.data.remote.PostApiService
import com.timzowen.apiintegrationcourse.postapiI.domain.model.Post
import com.timzowen.apiintegrationcourse.postapiI.domain.repository.PostRepository
import com.timzowen.apiintegrationcourse.postapiI.mapper.toDomain
import com.timzowen.apiintegrationcourse.postapiI.mapper.toDto

class PostRepositoryImpl(val postApiService: PostApiService) : PostRepository {

    override suspend fun getPosts(): List<Post> {
        return postApiService.getPosts().map {
            it.toDomain()
        }
    }

    override suspend fun createPost(post: Post): Post {
        return postApiService.createPost(post.toDto())
            .toDomain()
    }

}