package com.halilozcan.animearch.domain.mapper

import com.halilozcan.animearch.domain.entity.SingleAnimeEntity
import com.halilozcan.animearch.singleAnime
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotEquals
import org.junit.Before
import org.junit.Test

internal class SingleAnimeEntityMapperTest {

    private val singleAnimeEntityMapper: SingleAnimeEntityMapper = SingleAnimeEntityMapper()

    private lateinit var animeEntity: SingleAnimeEntity

    @Before
    fun setup() {
        animeEntity = singleAnimeEntityMapper.map(singleAnime)
    }

    @Test
    fun name_whenAnimeMappedWithName_isSame() {
        assertEquals(animeEntity.name, singleAnime.name)
    }

    @Test
    fun name_whenAnimeMappedWithKanjiName_isNotSame() {
        assertNotEquals(animeEntity.name, singleAnime.nameKanji)
    }

    @Test
    fun nameKanji_whenAnimeMapped_isSame() {
        assertEquals(animeEntity.nameKanji, singleAnime.nameKanji)
    }

    @Test
    fun imageUrl_whenAnimeMappedWithImageUrl_isSame() {
        assertEquals(animeEntity.imageUrl, singleAnime.images?.webp?.imageUrl)
    }

    @Test
    fun imageUrl_whenAnimeMappedSmallImageUrl_isNotSame() {
        assertNotEquals(animeEntity.imageUrl, singleAnime.images?.webp?.smallImageUrl)
    }
}