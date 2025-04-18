package com.example.dailypulse.di

import com.example.dailypulse.articles.ArticlesViewModel
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.koin.core.context.startKoin

fun initKoin(){
    val module = sharedKoinModule + databaseModule

    startKoin {
        modules(module)
    }
}

class ArticlesInjector: KoinComponent{
    val articlesViewModel : ArticlesViewModel by inject()
}