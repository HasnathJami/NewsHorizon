package com.jsn.newshorizon.presentation.search

import androidx.paging.PagingData
import com.jsn.newshorizon.domain.model.Article
import kotlinx.coroutines.flow.Flow

data class SearchState(
    val searchQuery: String = "",
    val articles: Flow<PagingData<Article>>? = null
)
