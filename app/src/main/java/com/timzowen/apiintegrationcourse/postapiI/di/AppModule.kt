package com.timzowen.apiintegrationcourse.postapiI.di

import com.timzowen.apiintegrationcourse.postapiI.data.remote.PostApiClient
import com.timzowen.apiintegrationcourse.postapiI.data.remote.PostApiService
import com.timzowen.apiintegrationcourse.postapiI.data.repository.PostRepositoryImpl
import com.timzowen.apiintegrationcourse.postapiI.domain.repository.PostRepository
import com.timzowen.apiintegrationcourse.ui.postapiI.PostViewModel
import org.koin.dsl.module

val appModule = module {
    single { PostApiClient.client }
    single { PostApiService(get()) }
    single { PostViewModel(get()) }
    single<PostRepository> { PostRepositoryImpl(get()) }
}