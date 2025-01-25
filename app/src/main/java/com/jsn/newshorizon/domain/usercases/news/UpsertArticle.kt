package com.jsn.newshorizon.domain.usercases.news

import com.jsn.newshorizon.data.local.NewsDao
import com.jsn.newshorizon.domain.model.Article

class UpsertArticle(private val newsDao: NewsDao) {
    suspend operator fun invoke(article: Article) {
        newsDao.upsert(article)
    }
}