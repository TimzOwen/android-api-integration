package com.timzowen.apiintegrationcourse.ui.postapi.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.timzowen.apiintegrationcourse.ui.postapi.screens.PostDetailsScreen
import com.timzowen.apiintegrationcourse.ui.postapi.screens.PostScreen

@Composable
fun AppNavGraph() {

    val navController = rememberNavController()

    NavHost(navController, startDestination = Routes.Posts.route) {

        composable(Routes.Posts.route) {
            PostScreen(navController)
        }

        composable(
            route = Routes.PostDetails.route,
            arguments = listOf(navArgument("id") { type = NavType.IntType })
        ) {
            val id = it.arguments?.getInt("id")
            PostDetailsScreen(id)
        }
    }

}