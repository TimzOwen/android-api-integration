package com.timzowen.apiintegrationcourse.ui.postapi.screens

import com.timzowen.apiintegrationcourse.postapi.domain.Post

sealed interface PostUiState {
    object Loading : PostUiState
    data class Success(val posts: List<Post>) : PostUiState
    data class Error(val errorMessage: String) : PostUiState
}