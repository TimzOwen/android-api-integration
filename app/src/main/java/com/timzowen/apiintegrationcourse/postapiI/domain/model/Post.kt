package com.timzowen.apiintegrationcourse.postapiI.domain.model

data class Post(
    val postId: Int,
    val postTitle: String,
    val postBody: String,
    val userId: Int,
)