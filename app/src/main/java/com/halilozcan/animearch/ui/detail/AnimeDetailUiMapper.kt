package com.halilozcan.animearch.ui.detail

import com.halilozcan.animearch.domain.entity.SingleAnimeEntity
import com.halilozcan.animearch.domain.mapper.AnimeBaseMapper
import com.halilozcan.animearch.ui.AnimeDetailUiData
import javax.inject.Inject

class AnimeDetailUiMapper @Inject constructor() :
    AnimeBaseMapper<SingleAnimeEntity, AnimeDetailUiData> {
    override fun map(input: SingleAnimeEntity): AnimeDetailUiData {
        return AnimeDetailUiData(
            input.name,
            input.nameKanji,
            input.description,
            input.imageUrl,
            input.favorites
        )
    }
}