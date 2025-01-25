package com.jsn.newshorizon.presentation.details

import com.jsn.newshorizon.domain.model.Article

sealed class DetailsEvent {
    data class UpsertDeleteEvent(val article: Article) : DetailsEvent()

    object RemoveSideEffect : DetailsEvent()
}