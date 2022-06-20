package com.cafeyn.domain

import com.cafeyn.domain.models.MyNews

object MyNews {
    private val newsItem1 = MyNews(1, "Title News 1", "https://www.google.fr", "https://www.google.fr")
    private val newsItem2 = MyNews(2, "Title News 2", "https://www.google.fr", "https://www.google.fr")
    private val newsItem3 = MyNews(3, "Title News 3", "https://www.google.fr", "https://www.google.fr")

    val listNewsItem = listOf(newsItem1, newsItem2, newsItem3)
}