package com.halilozcan.animearch.feature.detail


import androidx.annotation.VisibleForTesting
import com.halilozcan.animearch.core.common.AnimeDetailUiData
import com.halilozcan.animearch.core.domain.entity.SingleAnimeEntity

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

val animeDetailUiData = AnimeDetailUiData(
    name = "Lelouch Lamperouge",
    nameKanji = "ルルーシュ・ランペルージ",
    description = "",
    imageUrl = "https://cdn.myanimelist.net/images/characters/8/406163.webp",
    favorites = 159789
)

@VisibleForTesting
const val singleAnimePathId = "417"

@VisibleForTesting
const val idArg = "id"

