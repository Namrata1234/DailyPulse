package com.example.dailypulse.di

import com.example.dailypulse.articles.di.articleModule
import org.koin.dsl.module

val sharedKoinModule = listOf(
    articleModule,
    networkModule
)