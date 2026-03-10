package com.timzowen.apiintegrationcourse.postapi.data.dto

import com.timzowen.apiintegrationcourse.postapi.domain.Post

fun PostDto.toDomain(): Post {
    return Post(
        id = id,
        title = title,
        body = body
    )
}