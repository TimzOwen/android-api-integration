package com.timzowen.apiintegrationcourse

import android.app.Application
import com.timzowen.apiintegrationcourse.postapiI.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
//
//class PostApp : Application() {
//    override fun onCreate() {
//        super.onCreate()
//
//        startKoin {
//            androidContext(this@PostApp)
//            modules(appModule)
//        }
//
//    }
//}