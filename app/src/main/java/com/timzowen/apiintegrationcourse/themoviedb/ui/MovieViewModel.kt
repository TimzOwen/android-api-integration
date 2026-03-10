package com.timzowen.apiintegrationcourse.themoviedb.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.timzowen.apiintegrationcourse.themoviedb.domain.repository.MovieRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MovieViewModel(val repository: MovieRepository) : ViewModel() {

    private val _movieUiState = MutableStateFlow<MovieUiState>(MovieUiState.Loading)
    val movieUiState: StateFlow<MovieUiState> = _movieUiState

    init {
        getTrendingMovies()
    }

    private fun getTrendingMovies() {
        viewModelScope.launch {
            try {
                val movies = repository.getPopularMovies()
                _movieUiState.value = MovieUiState.Success(movies)

            } catch (e: Exception) {
                _movieUiState.value = MovieUiState.Error(e.toString())
            }
        }
    }

}