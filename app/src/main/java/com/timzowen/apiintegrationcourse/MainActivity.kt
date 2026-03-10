package com.timzowen.apiintegrationcourse

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.timzowen.apiintegrationcourse.themoviedb.navigation.MovieNavGraph
import com.timzowen.apiintegrationcourse.ui.postapi.navigation.AppNavGraph
import com.timzowen.apiintegrationcourse.ui.postapiI.navigation.AppMainNav
import com.timzowen.apiintegrationcourse.ui.theme.ApiIntegrationCourseTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ApiIntegrationCourseTheme {
//                AppNavGraph()
//                AppMainNav()
                MovieNavGraph()
            }
        }
    }
}

