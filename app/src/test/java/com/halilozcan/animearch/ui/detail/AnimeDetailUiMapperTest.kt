package com.halilozcan.animearch.ui.detail

import com.halilozcan.animearch.singleAnimeEntity
import com.halilozcan.animearch.ui.AnimeDetailUiData
import org.junit.Assert
import org.junit.Before
import org.junit.Test

internal class AnimeDetailUiMapperTest {

    private val animeDetailUiMapper = AnimeDetailUiMapper()

    private lateinit var animeDetailUiData: AnimeDetailUiData

    @Before
    fun setup() {
        animeDetailUiData = animeDetailUiMapper.map(singleAnimeEntity)
    }

    @Test
    fun name_whenAnimeMappedWithName_isSame() {
        Assert.assertEquals(animeDetailUiData.name, singleAnimeEntity.name)
    }

    @Test
    fun name_whenAnimeMappedWithKanjiName_isNotSame() {
        Assert.assertNotEquals(animeDetailUiData.name, singleAnimeEntity.nameKanji)
    }

    @Test
    fun nameKanji_whenAnimeMapped_isSame() {
        Assert.assertEquals(animeDetailUiData.nameKanji, singleAnimeEntity.nameKanji)
    }

    @Test
    fun imageUrl_whenAnimeMappedWithImageUrl_isSame() {
        Assert.assertEquals(animeDetailUiData.imageUrl, singleAnimeEntity.imageUrl)
    }

    @Test
    fun favorites_whenAnimeMapped_isSame() {
        Assert.assertEquals(animeDetailUiData.favorites, singleAnimeEntity.favorites)
    }
}