package com.jsn.newshorizon.presentation.common

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import com.jsn.newshorizon.domain.model.Article
import com.jsn.newshorizon.presentation.dimens.Dimens.ExtraSmallPadding
import com.jsn.newshorizon.presentation.dimens.Dimens.mediumPadding1

@Composable
fun ArticleList(
    modifier: Modifier = Modifier,
    articles: LazyPagingItems<Article>,
    onClick: (Article) -> Unit,
) {
    val handlePagingResult = handlePagingResult(articles = articles)
    if (handlePagingResult) {
        LazyColumn(
            modifier = modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(mediumPadding1),
            contentPadding = PaddingValues(all = ExtraSmallPadding)
        ) {
            items(count = articles.itemCount) { value ->
                articles[value]?.let {
                    ArticleCard(article = it, onClick = { onClick(it) })
                }
            }
        }
    }
}

@Composable
fun ArticlesList(
    modifier: Modifier = Modifier,
    articles: List<Article>,
    onClick: (Article) -> Unit,
) {
    if (articles.isEmpty()) {
        EmptyScreen()
    }
    LazyColumn(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(mediumPadding1),
        contentPadding = PaddingValues(all = ExtraSmallPadding)
    ) {
        items(count = articles.size) { value ->
            val article = articles[value]
            ArticleCard(article = article, onClick = { onClick(article) })

        }
    }
}

@Composable
fun handlePagingResult(modifier: Modifier = Modifier, articles: LazyPagingItems<Article>): Boolean {
    val loadState = articles.loadState
    val error = when {
        loadState.refresh is LoadState.Error -> loadState.refresh as LoadState.Error
        loadState.prepend is LoadState.Error -> loadState.prepend as LoadState.Error
        loadState.append is LoadState.Error -> loadState.append as LoadState.Error
        else -> null
    }
    return when {
        loadState.refresh is LoadState.Loading -> {
            ShimmerEffect()
            false
        }

        error != null -> {
            EmptyScreen(error = error)
            false
        }

        articles.itemCount == 0 -> {
            EmptyScreen()
            false
        }

        else -> {
            true
        }
    }
}

@Composable
private fun ShimmerEffect(modifier: Modifier = Modifier) {
    Column(verticalArrangement = Arrangement.spacedBy(mediumPadding1)) {
        repeat(10) {
            ArticleShimmerEffect(modifier = Modifier.padding(horizontal = mediumPadding1))
        }
    }
}