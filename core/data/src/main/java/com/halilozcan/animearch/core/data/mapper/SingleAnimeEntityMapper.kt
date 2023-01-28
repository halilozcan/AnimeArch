package com.halilozcan.animearch.core.data.mapper

import com.halilozcan.animearch.core.data.dto.single.AnimeCharacter
import com.halilozcan.animearch.core.domain.entity.SingleAnimeEntity
import com.halilozcan.animearch.core.domain.mapper.AnimeBaseMapper
import javax.inject.Inject

class SingleAnimeEntityMapper @Inject constructor() :
    AnimeBaseMapper<AnimeCharacter, SingleAnimeEntity> {
    override fun map(input: AnimeCharacter): SingleAnimeEntity {
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
