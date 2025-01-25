package com.jsn.newshorizon.domain.usercases.news

import com.jsn.newshorizon.data.local.NewsDao
import com.jsn.newshorizon.domain.model.Article
import kotlinx.coroutines.flow.Flow

class SelectArticles(private val newsDao: NewsDao) {
    operator fun invoke(): Flow<List<Article>> = newsDao.getArticles()

}