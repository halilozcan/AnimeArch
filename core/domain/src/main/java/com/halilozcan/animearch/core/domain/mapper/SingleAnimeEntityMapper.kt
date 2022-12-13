package com.halilozcan.animearch.core.domain.mapper

import com.halilozcan.animearch.core.domain.entity.SingleAnimeEntity
import javax.inject.Inject

class SingleAnimeEntityMapper @Inject constructor() :
    AnimeBaseMapper<com.halilozcan.animearch.core.data.dto.single.AnimeCharacter, SingleAnimeEntity> {

    override fun map(input: com.halilozcan.animearch.core.data.dto.single.AnimeCharacter): SingleAnimeEntity {
        return SingleAnimeEntity(
            id = input.malId!!.toString(),
            name = input.name.orEmpty(),
            nameKanji = input.nameKanji.orEmpty(),
            description = input.about.orEmpty(),
            favorites = input.favorites ?: 0,
            imageUrl = input.images?.webp?.imageUrl.orEmpty()
        )
    }
}
