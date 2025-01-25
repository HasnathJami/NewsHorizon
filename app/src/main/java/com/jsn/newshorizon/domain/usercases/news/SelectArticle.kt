package com.jsn.newshorizon.domain.usercases.news

import com.jsn.newshorizon.data.local.NewsDao
import com.jsn.newshorizon.domain.model.Article
import com.jsn.newshorizon.domain.repository.NewsRepository

class SelectArticle(private val newsRepository: NewsRepository) {
    suspend operator fun invoke(url: String): Article? {
        return newsRepository.selectArticle(url)
    }
}