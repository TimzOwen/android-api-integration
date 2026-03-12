package com.timzowen.apiintegrationcourse.themovieapi.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.timzowen.apiintegrationcourse.themovieapi.ui.MovieScreen
import kotlinx.serialization.Serializable


@Composable
fun MovieAppNavigation() {
    val navController = rememberNavController()

    NavHost(navController, Home) {
        composable<Home> {
            MovieScreen()
        }
    }
}

@Serializable
object Home