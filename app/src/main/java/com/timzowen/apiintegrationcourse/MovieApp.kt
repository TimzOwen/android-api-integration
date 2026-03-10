package com.timzowen.apiintegrationcourse

import android.app.Application
import com.timzowen.apiintegrationcourse.themoviedb.di.appModule as movieAppModule
import com.timzowen.apiintegrationcourse.postapiI.di.appModule as postAppModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MovieApp : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MovieApp)
            modules(movieAppModule)
        }
    }
}