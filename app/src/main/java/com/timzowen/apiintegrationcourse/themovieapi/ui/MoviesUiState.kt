package com.timzowen.apiintegrationcourse.themovieapi.ui

import com.timzowen.apiintegrationcourse.themovieapi.domain.model.Movie


sealed interface MoviesUiState {

    object Loading : MoviesUiState

    data class Success(val movies: List<Movie>) : MoviesUiState

    data class Error(val errorMessage: String): MoviesUiState

}
