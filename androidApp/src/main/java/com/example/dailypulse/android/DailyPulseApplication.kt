package com.example.dailypulse.android

import android.app.Application
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
       val modules = sharedKoinModule + viewModelModule

        startKoin {
            androidContext(this@DailyPulseApplication)
            modules(modules)
        }
    }
}