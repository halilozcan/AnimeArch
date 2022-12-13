package com.halilozcan.animearch.feature.detail

import com.halilozcan.animearch.core.common.AnimeDetailUiData
import com.halilozcan.animearch.core.domain.entity.SingleAnimeEntity
import com.halilozcan.animearch.core.domain.mapper.AnimeBaseMapper
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