package com.jsn.newshorizon.domain.repository

import androidx.paging.PagingData
import com.jsn.newshorizon.domain.model.Article
import kotlinx.coroutines.flow.Flow

interface NewsRepository {
    fun getNews(sources: List<String>): Flow<PagingData<Article>>
}