package com.timzowen.apiintegrationcourse.ui.postapiI

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.timzowen.apiintegrationcourse.postapiI.domain.model.Post
import com.timzowen.apiintegrationcourse.postapiI.domain.repository.PostRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.lang.Exception

class PostViewModel(val postRepository: PostRepository) : ViewModel() {

    private val _uiState = MutableStateFlow<PostUiState>(PostUiState.Idle)
    val uiState: StateFlow<PostUiState> = _uiState.asStateFlow()

    fun loadPosts() {
        viewModelScope.launch {
            _uiState.value = PostUiState.Loading
            try {
                val posts = postRepository.getPosts()
                _uiState.value = PostUiState.Success(posts)
            } catch (e: Exception) {
                _uiState.value = PostUiState.Error(e.message ?: "Unknown Error")
            }
        }
    }

    fun createPost(title: String, body: String) {
        viewModelScope.launch {
            try {
                postRepository.createPost(
                    Post(
                        postId = 0,
                        postTitle = title,
                        postBody = body,
                        userId = 1
                    )
                )
                loadPosts()
            } catch (e: Exception) {
                _uiState.value = PostUiState.Error(e.message ?: "Unknow Error")
            }
        }
    }
}