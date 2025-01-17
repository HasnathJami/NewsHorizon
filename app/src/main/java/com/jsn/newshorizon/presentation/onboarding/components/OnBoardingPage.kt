package com.jsn.newshorizon.presentation.onboarding.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import com.jsn.newshorizon.R
import com.jsn.newshorizon.model.Page
import com.jsn.newshorizon.presentation.dimens.Dimens.mediumPadding1
import com.jsn.newshorizon.presentation.dimens.Dimens.mediumPadding2

@Composable
fun OnBoardingPage(page: Page, modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(fraction = 0.6f),
            contentDescription = null,
            painter = painterResource(id = page.image),
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.height(mediumPadding1))
        Text(
            text = page.title, modifier = Modifier.padding(horizontal = mediumPadding2),
            style = MaterialTheme.typography.displaySmall.copy(fontWeight = FontWeight.Bold),
            color = colorResource(id = R.color.display_small)
        )
        Text(
            text = page.description, modifier = Modifier.padding(horizontal = mediumPadding2),
            style = MaterialTheme.typography.bodyMedium,
            color = colorResource(id = R.color.text_medium)
        )

    }
}

//@Preview(showBackground = true)
//@Preview(showBackground = true, uiMode = UI_MODE_NIGHT_YES)
//@Composable
//fun OnBoardingPreview() {
//    NewsHorizonTheme {
//        OnBoardingPage(page = pages[0])
//    }
//}