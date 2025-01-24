package com.jsn.newshorizon.presentation.details

sealed class DetailsEvent {
    object SaveArticle : DetailsEvent()
}