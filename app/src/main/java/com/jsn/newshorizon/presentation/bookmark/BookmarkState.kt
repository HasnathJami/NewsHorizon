package com.jsn.newshorizon.presentation.bookmark

import com.jsn.newshorizon.domain.model.Article

data class BookmarkState(
    val articles: List<Article> = emptyList()
)