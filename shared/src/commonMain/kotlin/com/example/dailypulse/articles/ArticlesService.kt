package com.example.dailypulse.articles

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

class ArticlesService(private val httpClient:HttpClient) {

    private  val country="us"
    private val category ="business"
    private val apiKey="1e6bdc9dc7374d6f8efccde31afb93b7"


    suspend fun fetchArticles() : List<ArticlesRaw>{
        val response:ArticlesResponse = httpClient.get("https://newsapi.org/v2/top-headlines?country=$country&category=$category&apiKey=$apiKey").body()
        return  response.articles
    }
}