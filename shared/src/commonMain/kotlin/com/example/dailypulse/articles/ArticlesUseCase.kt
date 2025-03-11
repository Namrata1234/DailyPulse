package com.example.dailypulse.articles

import kotlinx.datetime.Clock
import kotlinx.datetime.Instant
import kotlinx.datetime.TimeZone
import kotlinx.datetime.daysUntil
import kotlinx.datetime.toLocalDateTime
import kotlinx.datetime.todayIn
import kotlin.math.abs

class ArticlesUseCase(private val service: ArticlesService) {

    suspend fun getArticles() :List<Article>{
        val articleRow = service.fetchArticles()
        return mapArticles(articleRow)
    }

    private fun mapArticles(articleRow: List<ArticlesRaw>): List<Article> = articleRow.map {
        articlesRaw -> Article(articlesRaw.title.toString(),articlesRaw.description?:"Click to find out more",
            dateFormat(articlesRaw.date.toString()),articlesRaw.imageUrl.toString())
    }


    private fun dateFormat(dateString: String) : String{
        val today= Clock.System.todayIn(TimeZone.currentSystemDefault())
        val days = today.daysUntil(
        Instant.parse(dateString).toLocalDateTime(TimeZone.currentSystemDefault()).date
        )

        val result = when{
            abs(days) > 1 -> "${abs(days)} days ago"
            abs(days) == 1 -> "Yesterday"
            else -> "Today"

        }

        return  result

    }
}