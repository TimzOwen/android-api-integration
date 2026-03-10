package com.timzowen.apiintegrationcourse.themoviedb.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.timzowen.apiintegrationcourse.themoviedb.ui.MovieScreen
import com.timzowen.apiintegrationcourse.themoviedb.ui.MovieViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun MovieNavGraph() {

    val navController = rememberNavController()

    NavHost(navController, startDestination = HomeRoute) {

        composable<HomeRoute> {
            MovieScreen()
        }
    }

}