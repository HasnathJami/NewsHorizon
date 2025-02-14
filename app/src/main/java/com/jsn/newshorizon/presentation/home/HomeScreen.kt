package com.jsn.newshorizon.presentation.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.basicMarquee
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.paging.compose.LazyPagingItems
import com.jsn.newshorizon.R
import com.jsn.newshorizon.domain.model.Article
import com.jsn.newshorizon.presentation.common.ArticleList
import com.jsn.newshorizon.presentation.common.SearchBar
import com.jsn.newshorizon.presentation.dimens.Dimens

@Composable
fun HomeScreen(
    articles: LazyPagingItems<Article>,
    navigateToSearch: () -> Unit,
    navigateToDetails: (Article) -> Unit
) {
    val titles by remember {
        derivedStateOf {
            if (articles.itemCount > 10) {
                articles.itemSnapshotList.items.slice(
                    IntRange(start = 0, endInclusive = 9)
                ).joinToString(separator = " \uD83d\uDFE5") { it.title }
            } else {
                ""
            }
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = Dimens.mediumPadding1)
            .statusBarsPadding()
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_logo),
            contentDescription = null,
            modifier = Modifier
                .width(150.dp)
                .height(30.dp)
                .padding(horizontal = Dimens.mediumPadding1)
        )
        Spacer(modifier = Modifier.height(Dimens.mediumPadding1))

        SearchBar(
            modifier = Modifier.padding(horizontal = Dimens.mediumPadding1),
            text = "",
            readOnly = true,
            onClick = {
//                navigate(Route.SearchScreen.route)
                navigateToSearch()
            },
            onSearch = {},
            onValueChange = {}
        )

        Spacer(modifier = Modifier.height(Dimens.mediumPadding1))

        Text(
            text = titles,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = Dimens.mediumPadding1)
                .basicMarquee(),
            fontSize = 12.sp,
            color = colorResource(id = R.color.placeholder)
        )

        Spacer(modifier = Modifier.height(Dimens.mediumPadding1))

        ArticleList(
            modifier = Modifier.padding(horizontal = Dimens.mediumPadding1),
            articles = articles,
            onClick = {
                navigateToDetails(it)
//                navigate(Route.DetailsScreen.route)
            }

        )
    }
}

