package com.example.dailypulse.articles

import com.example.dailypulse.db.DailyPulseDatabase
import com.example.dailypulse.articles.ArticlesRaw

class ArticlesDataSource(private val database: DailyPulseDatabase) {

    fun getAllArticles(): List<ArticlesRaw> =
        database.dailyPulseDatabaseQueries.selectAllArticles(::mapToArticlesRaw).executeAsList()

    fun insertArticles(articles: List<ArticlesRaw>) {
        database.dailyPulseDatabaseQueries.transaction {
            articles.forEach { articlesRaw ->
                insertArticle(articlesRaw)
            }
        }
    }

    fun clearArticles() =
        database.dailyPulseDatabaseQueries.removeAllArticles()

    private fun insertArticle(articlesRaw: ArticlesRaw) {
        articlesRaw.title?.let {
            articlesRaw.date?.let { it1 ->
                database.dailyPulseDatabaseQueries.insertArticle(
                    it,
                    articlesRaw.description,
                    it1,
                    articlesRaw.imageUrl
                )
            }
        }
    }
    private fun mapToArticlesRaw(
        title: String,
        desc: String?,
        date: String,
        url: String?
    ): ArticlesRaw = ArticlesRaw(
            title,
            desc,
            date,
            url
    )
}