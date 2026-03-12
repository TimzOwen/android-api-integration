package com.timzowen.apiintegrationcourse.themoviedb.di

import com.timzowen.apiintegrationcourse.themoviedb.data.MovieRepositoryImpl
import com.timzowen.apiintegrationcourse.themoviedb.data.remote.MovieApi
import com.timzowen.apiintegrationcourse.themoviedb.domain.repository.MovieRepository
import com.timzowen.apiintegrationcourse.themoviedb.network.HttpClientFactory
import com.timzowen.apiintegrationcourse.themoviedb.ui.MovieViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val appModule = module {
    single { HttpClientFactory.create() }
    single { MovieApi(get()) }
    viewModel { MovieViewModel(get()) }
    single<MovieRepository> { MovieRepositoryImpl(get()) }
}
