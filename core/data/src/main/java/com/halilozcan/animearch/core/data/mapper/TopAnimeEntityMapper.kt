package com.halilozcan.animearch.core.data.mapper

import com.halilozcan.animearch.core.data.dto.top.Anime
import com.halilozcan.animearch.core.domain.entity.TopAnimeEntity
import com.halilozcan.animearch.core.domain.mapper.AnimeListMapper
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
