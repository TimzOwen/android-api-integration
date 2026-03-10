package com.timzowen.apiintegrationcourse

import android.app.Application
import com.timzowen.apiintegrationcourse.postapi.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

//class PostsApplication : Application() {
//    override fun onCreate() {
//        super.onCreate()
//
//        startKoin {
//            androidContext(this@PostsApplication)
//            modules(appModule)
//        }
//
//    }
//}