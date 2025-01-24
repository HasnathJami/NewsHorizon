package com.jsn.newshorizon.domain.usercases.news

import androidx.paging.PagingData
import com.jsn.newshorizon.domain.model.Article
import com.jsn.newshorizon.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow

class SearchNews(private val newsRepository: NewsRepository) {
    operator fun invoke(searchQuery: String, sources: List<String>): Flow<PagingData<Article>> {
        return newsRepository.searchNews(searchQuery, sources)
    }
}