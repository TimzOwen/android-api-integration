package com.timzowen.apiintegrationcourse.ui.postapi.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.timzowen.apiintegrationcourse.ui.postapi.screens.PostUiState
import com.timzowen.apiintegrationcourse.ui.postapi.screens.PostViewModel
import com.timzowen.apiintegrationcourse.ui.postapi.navigation.Routes
import org.koin.androidx.compose.koinViewModel

@Composable
fun PostScreen(
    navController: NavController,
    viewModel: PostViewModel = koinViewModel()
) {

    val uiState by viewModel.uiState.collectAsState()

    when (uiState) {
        PostUiState.Loading -> CircularProgressIndicator()

        is PostUiState.Success -> {
            val posts = (uiState as PostUiState.Success).posts

            LazyColumn {
                items(posts) { post ->
                    Text(
                        text = post.title,
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable {
                                navController.navigate(Routes.PostDetails.createRoute(post.id))
                            }
                            .padding(16.dp)
                    )
                }
            }

        }

        is PostUiState.Error -> Text("Error loading")
    }

}