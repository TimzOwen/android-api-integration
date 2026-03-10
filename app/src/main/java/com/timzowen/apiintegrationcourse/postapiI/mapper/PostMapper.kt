package com.timzowen.apiintegrationcourse.postapiI.mapper

import com.timzowen.apiintegrationcourse.postapiI.data.remote.dto.PostDto
import com.timzowen.apiintegrationcourse.postapiI.domain.model.Post


fun PostDto.toDomain(): Post {
    return Post(
        postId = id ?: 0,
        postTitle = title.orEmpty(),
        postBody = body.orEmpty(),
        userId = userId ?: 0
    )
}

fun Post.toDto(): PostDto {
    return PostDto(
        id = postId,
        title = postTitle,
        body = postBody,
        userId = userId
    )
}