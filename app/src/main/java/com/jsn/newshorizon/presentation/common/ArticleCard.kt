package com.jsn.newshorizon.presentation.common

import android.content.res.Configuration
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.jsn.newshorizon.R
import com.jsn.newshorizon.domain.model.Article
import com.jsn.newshorizon.domain.model.Source
import com.jsn.newshorizon.presentation.dimens.Dimens
import com.jsn.newshorizon.presentation.dimens.Dimens.ArticleCardSize
import com.jsn.newshorizon.presentation.dimens.Dimens.ExtraSmallPadding
import com.jsn.newshorizon.presentation.dimens.Dimens.SmallIconSize
import com.jsn.newshorizon.ui.theme.NewsHorizonTheme

@Composable
fun ArticleCard(
    modifier: Modifier = Modifier,
    article: Article,
    onClick: () -> Unit

) {
    val context = LocalContext.current
    Row(
        modifier = modifier.clickable { onClick() }
    ) {
        AsyncImage(
            modifier = Modifier
                .size(ArticleCardSize)
                .clip(MaterialTheme.shapes.medium),
            contentScale = ContentScale.Crop,
            model = ImageRequest.Builder(context).data(article.urlToImage).build(),
            contentDescription = null,
        )

        Column(
            verticalArrangement = Arrangement.SpaceAround,
            modifier = Modifier
                .padding(horizontal = ExtraSmallPadding)
                .height(ArticleCardSize)

        ) {
            Text(
                text = article.title,
                style = MaterialTheme.typography.bodyMedium,
                color = colorResource(id = R.color.text_title),
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
            Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(Dimens.ExtraSmallPadding2) ) {
                Text(
                    text = article.source.name,
                    style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.Bold)                                                                       ,
                    color = colorResource(id = R.color.body),
                )
                //Spacer(modifier = Modifier.width(Dimens.ExtraSmallPadding2))
                Icon(
                    painter = painterResource(id = R.drawable.ic_time),
                    contentDescription = null,
                    modifier = Modifier.size(SmallIconSize),
                    tint = colorResource(id = R.color.body)
                )
               // Spacer(modifier = Modifier.width(Dimens.ExtraSmallPadding2))
                Text(
                    text = article.publishedAt,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.Bold)                                                                       ,
                    color = colorResource(id = R.color.body),
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun ArticlePreview() {
    NewsHorizonTheme {
        ArticleCard(
            article = Article(
                author = "jjj",
                content = "ddd",
                description = "ddddddddddd",
                publishedAt = "23 hours",
                source = Source(id = "1", name = "333d"),
                title = "News article for testing purpose",
                url = "dddd",
                urlToImage = ""
            )
        ) {
        }
    }
}