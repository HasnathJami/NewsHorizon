package com.jsn.newshorizon.domain.usercases.news

import com.jsn.newshorizon.data.local.NewsDao
import com.jsn.newshorizon.domain.model.Article
import com.jsn.newshorizon.domain.repository.NewsRepository

class UpsertArticle(private val newsRepository: NewsRepository) {
    suspend operator fun invoke(article: Article) {
        newsRepository.upsertArticle(article)
    }
}