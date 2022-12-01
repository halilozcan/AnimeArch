package com.halilozcan.animearch.domain.mapper

import com.halilozcan.animearch.data.dto.top.Anime
import com.halilozcan.animearch.domain.entity.TopAnimeEntity
import javax.inject.Inject

class TopAnimeEntityMapper @Inject constructor() : AnimeListMapper<Anime, TopAnimeEntity> {

    override fun map(input: List<Anime>): List<TopAnimeEntity> {
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
