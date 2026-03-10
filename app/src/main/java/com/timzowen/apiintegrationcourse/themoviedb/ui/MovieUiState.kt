package com.timzowen.apiintegrationcourse.themoviedb.ui

import com.timzowen.apiintegrationcourse.themoviedb.domain.model.Movie


sealed interface MovieUiState {

    object Loading : MovieUiState

    data class Success(val movies: List<Movie>) : MovieUiState

    data class Error(val errorMessage: String): MovieUiState

}
