package com.halilozcan.animearch.domain.mapper

import com.halilozcan.animearch.data.dto.single.AnimeCharacter
import com.halilozcan.animearch.domain.entity.SingleAnimeEntity
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
