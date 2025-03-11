package com.example.dailypulse.articles

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class ArticlesRaw(
    @SerialName("title")
    val title:String?,
    @SerialName("description")
    val description:String?,
    @SerialName("publishedAt")
    val date:String?,
    @SerialName("urlToImage")
    val imageUrl:String?
)
