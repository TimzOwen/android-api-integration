package com.timzowen.apiintegrationcourse.postapi.data.dto

import kotlinx.serialization.Serializable

@Serializable
data class PostDto(
    val id: Int,
    val title: String,
    val body: String,
    val userId: Int
)