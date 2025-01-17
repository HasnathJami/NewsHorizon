package com.jsn.newshorizon.model

import androidx.annotation.DrawableRes
import com.jsn.newshorizon.R

data class Page(
    val title: String,
    val description: String,
    @DrawableRes
    val image: Int
)

val pages: List<Page> = listOf(
    Page(
        title = "Splash 1",
        description = "Splash 1 Description",
        image = R.drawable.splash_first
    ),
    Page(
        title = "Splash 2",
        description = "Splash 2 Description",
        image = R.drawable.splash_second
    ),
    Page(
        title = "Splash 3",
        description = "Splash 3 Description",
        image = R.drawable.splash_third
    ),
)
