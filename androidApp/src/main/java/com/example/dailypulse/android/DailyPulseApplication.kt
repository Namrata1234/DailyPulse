package com.example.dailypulse.android

import android.app.Application
import com.example.dailypulse.android.di.databaseModule
import com.example.dailypulse.android.di.viewModelModule
import com.example.dailypulse.di.sharedKoinModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class DailyPulseApplication :Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin()
    }

    private fun initKoin() {
       val modules = sharedKoinModule + viewModelModule + databaseModule

        startKoin {
            androidContext(this@DailyPulseApplication)
            modules(modules)
        }
    }
}