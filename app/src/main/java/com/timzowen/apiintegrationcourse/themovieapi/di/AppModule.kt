package com.timzowen.apiintegrationcourse.themovieapi.di

import com.timzowen.apiintegrationcourse.themovieapi.data.MovieApiService
import com.timzowen.apiintegrationcourse.themovieapi.data.repository.MovieRepoImpl
import com.timzowen.apiintegrationcourse.themovieapi.domain.repository.MovieApiRepository
import com.timzowen.apiintegrationcourse.themovieapi.network.MovieNetworkClient
import com.timzowen.apiintegrationcourse.themovieapi.ui.MovieViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import kotlin.math.sin

val appModule = module {

    single { MovieNetworkClient.createClient() }
    single { MovieApiService(get()) }
    single<MovieApiRepository> { MovieRepoImpl(get()) }
    viewModel { MovieViewModel(get()) }

}