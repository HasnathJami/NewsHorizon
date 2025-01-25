package com.jsn.newshorizon.presentation.search

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.paging.compose.collectAsLazyPagingItems
import com.jsn.newshorizon.domain.model.Article
import com.jsn.newshorizon.presentation.common.ArticleList
import com.jsn.newshorizon.presentation.common.SearchBar
import com.jsn.newshorizon.presentation.dimens.Dimens.mediumPadding1
import com.jsn.newshorizon.presentation.navgraph.Route

@Composable
fun SearchScreen(state: SearchState, event: (SearchEvent) -> Unit, navigateToDetails: (Article) -> Unit) {

    Column(
        modifier = Modifier
            .padding(
                top = mediumPadding1,
                start = mediumPadding1,
                end = mediumPadding1
            )
            .statusBarsPadding()
    ) {
        SearchBar(
            text = state.searchQuery,
            readOnly = false,
            onValueChange = {
                event(SearchEvent.UpdateSearchQuery(it))
//                event(SearchEvent.SearchNews) // call this if you want to search items on each key-press on the edit text
            },
            onSearch = {
                event(SearchEvent.SearchNews)
            }
        )


        Spacer(modifier = Modifier.height(mediumPadding1))
        state.articles?.let {
            val article = it.collectAsLazyPagingItems()
            ArticleList(articles = article, onClick = {
                navigateToDetails(it)
            })
        }
    }

}