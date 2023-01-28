package com.halilozcan.animearch.core.domain


import androidx.annotation.VisibleForTesting
import com.halilozcan.animearch.core.domain.entity.SingleAnimeEntity
import com.halilozcan.animearch.core.domain.entity.TopAnimeEntity

@VisibleForTesting
const val singleAnimePathId = "417"

@VisibleForTesting
val singleAnimeEntity =
    SingleAnimeEntity(
        id = "417",
        name = "Levi",
        nameKanji = "ルルーシュ・ランペルージ",
        description = "",
        imageUrl = "https://cdn.myanimelist.net/images/characters/8/406163.webp",
        favorites = 159789
    )

@VisibleForTesting
val topAnimeEntity = TopAnimeEntity(
    id = "417",
    name = "Lelouch Lamperouge",
    description = "",
    imageUrl = "https://cdn.myanimelist.net/images/characters/8/406163.webp"
)

@VisibleForTesting
val topAnimeEntities = listOf(topAnimeEntity)

