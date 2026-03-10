package com.timzowen.apiintegrationcourse.ui.postapi.navigation

sealed class Routes(val route: String) {

    data object Posts : Routes("posts")

    data object PostDetails : Routes("post/{id}") {
        fun createRoute(id: Int) = "post/$id"
    }

}