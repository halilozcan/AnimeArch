package com.halilozcan.animearch.core.domain.mapper

import com.halilozcan.animearch.core.domain.entity.TopAnimeEntity
import javax.inject.Inject

class TopAnimeEntityMapper @Inject constructor() :
    AnimeListMapper<com.halilozcan.animearch.core.data.dto.top.Anime, TopAnimeEntity> {

    override fun map(input: List<com.halilozcan.animearch.core.data.dto.top.Anime>): List<TopAnimeEntity> {
        return input.map {
            TopAnimeEntity(
                it.malId?.toString().orEmpty(),
                it.name!!,
                it.about!!,
                it.images?.webp?.imageUrl ?: ""
            )
        }
    }
}
