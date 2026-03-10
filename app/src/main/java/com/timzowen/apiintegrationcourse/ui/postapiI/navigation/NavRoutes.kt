package com.timzowen.apiintegrationcourse.ui.postapiI.navigation

import kotlinx.serialization.Serializable

@Serializable
sealed class NavRoutes {

    @Serializable
    object PostList

    @Serializable
    object CreatePost

}