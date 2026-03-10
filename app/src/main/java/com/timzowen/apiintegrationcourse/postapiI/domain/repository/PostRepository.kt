package com.timzowen.apiintegrationcourse.postapiI.domain.repository

import com.timzowen.apiintegrationcourse.postapiI.domain.model.Post

interface PostRepository {

    suspend fun getPosts(): List<Post>

    suspend fun createPost(post: Post): Post

}