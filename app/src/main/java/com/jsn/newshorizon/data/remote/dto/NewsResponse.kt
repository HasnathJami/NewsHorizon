package com.jsn.newshorizon.data.remote.dto

import com.jsn.newshorizon.domain.model.Article

data class NewsResponse(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)