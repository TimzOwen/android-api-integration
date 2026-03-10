package com.timzowen.apiintegrationcourse.postapi.data.repository

import com.timzowen.apiintegrationcourse.postapi.domain.Post

interface PostRepository {

    suspend fun getAllPosts(): List<Post>

}