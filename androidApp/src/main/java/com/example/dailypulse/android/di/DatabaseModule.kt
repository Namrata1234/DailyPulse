package com.example.dailypulse.android.di

import app.cash.sqldelight.db.SqlDriver
import com.example.dailypulse.db.DatabaseDriverFactory
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import com.example.dailypulse.db.DailyPulseDatabase

val databaseModule = module{

    single<SqlDriver> { DatabaseDriverFactory(androidContext()).createDriver() }

    single<DailyPulseDatabase> { DailyPulseDatabase(get()) }
}