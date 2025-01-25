package com.jsn.newshorizon.domain.usercases.news

import com.jsn.newshorizon.data.local.NewsDao
import com.jsn.newshorizon.domain.model.Article
import com.jsn.newshorizon.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow

class SelectArticles(private val newsRepository: NewsRepository) {
    operator fun invoke(): Flow<List<Article>> = newsRepository.selectArticles()

}