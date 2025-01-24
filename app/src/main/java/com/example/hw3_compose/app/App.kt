package com.example.hw3_compose.app

import android.app.Application
import com.example.hw3_compose.data.serviceLocator.dataModule
import com.example.hw3_compose.data.serviceLocator.uiModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(dataModule)
            modules(uiModule)
        }
    }
}