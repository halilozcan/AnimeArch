package com.halilozcan.animearch.ui.home

import com.halilozcan.animearch.domain.entity.TopAnimeEntity
import com.halilozcan.animearch.domain.mapper.AnimeListMapper
import com.halilozcan.animearch.ui.AnimeHomeUiData
import javax.inject.Inject

class AnimeHomeUiMapper @Inject constructor() : AnimeListMapper<TopAnimeEntity, AnimeHomeUiData> {
    override fun map(input: List<TopAnimeEntity>): List<AnimeHomeUiData> {
        return input.map {
            AnimeHomeUiData(it.id, it.name, it.description, it.imageUrl)
        }
    }
}