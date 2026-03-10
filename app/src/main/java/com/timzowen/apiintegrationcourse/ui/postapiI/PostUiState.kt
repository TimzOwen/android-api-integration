package com.timzowen.apiintegrationcourse.ui.postapiI

import com.timzowen.apiintegrationcourse.postapiI.domain.model.Post

sealed class PostUiState {
    object Idle : PostUiState()
    object Loading : PostUiState()
    data class Success(val posts: List<Post>) : PostUiState()
    data class Error(val message: String) : PostUiState()

}