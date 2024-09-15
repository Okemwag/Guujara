package com.okemwag.movies.android

import android.app.Application
import com.okemwag.movies.android.di.appModule
import com.okemwag.movies.di.getSharedModules
import org.koin.core.context.startKoin

class Movie: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(appModule + getSharedModules())
        }
    }
}