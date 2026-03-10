package com.timzowen.apiintegrationcourse.postapi.di

import com.timzowen.apiintegrationcourse.postapi.data.remote.ApiService
import com.timzowen.apiintegrationcourse.postapi.data.remote.PostApiClient.provideHttpClient
import com.timzowen.apiintegrationcourse.postapi.data.repository.PostRepository
import com.timzowen.apiintegrationcourse.postapi.data.repository.PostRepositoryImpl
import com.timzowen.apiintegrationcourse.ui.postapi.screens.PostViewModel
import io.ktor.client.HttpClient
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    single<HttpClient> { provideHttpClient() }

    single<ApiService> { ApiService(get()) }

    single<PostRepository> { PostRepositoryImpl(get()) }

    viewModel { PostViewModel(get()) }

}