package com.halilozcan.animearch.feature.home


import androidx.annotation.VisibleForTesting
import com.halilozcan.animearch.core.common.AnimeHomeUiData
import com.halilozcan.animearch.core.domain.entity.TopAnimeEntity

@VisibleForTesting
val topAnimeEntity = TopAnimeEntity(
    id = "417",
    name = "Lelouch Lamperouge",
    description = "",
    imageUrl = "https://cdn.myanimelist.net/images/characters/8/406163.webp"
)


@VisibleForTesting
val topAnimeEntities = listOf(topAnimeEntity)

@VisibleForTesting
val animeHomeUiData = AnimeHomeUiData(
    id = "417",
    name = "Lelouch Lamperouge",
    description = "",
    imageUrl = "https://cdn.myanimelist.net/images/characters/8/406163.webp"
)

@VisibleForTesting
val topAnimeUiList = listOf(animeHomeUiData)

