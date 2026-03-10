package com.timzowen.apiintegrationcourse.ui.postapiI.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.timzowen.apiintegrationcourse.ui.postapiI.CreatePostScreen
import com.timzowen.apiintegrationcourse.ui.postapiI.PostListScreen

@Composable
fun AppMainNav() {

    val navController = rememberNavController()

    NavHost(navController, startDestination = NavRoutes.PostList) {

        composable<NavRoutes.PostList> {
            PostListScreen(navController)
        }
        composable<NavRoutes.CreatePost> {
            CreatePostScreen(navController)
        }
    }

}