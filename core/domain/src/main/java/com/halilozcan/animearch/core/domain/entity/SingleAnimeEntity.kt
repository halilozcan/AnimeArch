package com.halilozcan.animearch.core.domain.entity

data class SingleAnimeEntity(
    val id: String,
    val name: String,
    val nameKanji: String,
    val description: String,
    val imageUrl: String,
    val favorites: Int,
)