package com.example.hw3_compose.app

import android.app.Application
import androidx.room.Room
import com.example.hw3_compose.data.db.AppDatabase
import com.example.hw3_compose.data.serviceLocator.dataModule
import com.example.hw3_compose.data.serviceLocator.uiModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {
    lateinit var database: AppDatabase

    override fun onCreate() {
        super.onCreate()

        database = Room.databaseBuilder(
            this,
            AppDatabase::class.java,
            "app_database"
        ).build()

        startKoin {
            androidContext(this@App)
            modules(dataModule, uiModule)
        }
    }
}