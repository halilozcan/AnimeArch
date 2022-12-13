package com.halilozcan.animearch.feature.home

import com.halilozcan.animearch.core.common.AnimeHomeUiData
import com.halilozcan.animearch.core.domain.entity.TopAnimeEntity
import com.halilozcan.animearch.core.domain.mapper.AnimeListMapper
import javax.inject.Inject

class AnimeHomeUiMapper @Inject constructor() :
    AnimeListMapper<TopAnimeEntity, AnimeHomeUiData> {
    override fun map(input: List<TopAnimeEntity>): List<AnimeHomeUiData> {
        return input.map {
            AnimeHomeUiData(it.id, it.name, it.description, it.imageUrl)
        }
    }
}