package com.halilozcan.animearch.ui.home

import com.halilozcan.animearch.topAnimeEntities
import com.halilozcan.animearch.ui.AnimeHomeUiData
import org.junit.Assert
import org.junit.Before
import org.junit.Test

internal class AnimeHomeUiMapperTest {

    private val animeHomeUiMapper = AnimeHomeUiMapper()

    private lateinit var animeHomeUiList: List<AnimeHomeUiData>

    @Before
    fun setup() {
        animeHomeUiList = animeHomeUiMapper.map(topAnimeEntities)
    }

    @Test
    fun animeListSize_whenAnimeMapped_isSameSize() {
        Assert.assertEquals(animeHomeUiList.size, topAnimeEntities.size)
    }

    @Test
    fun name_whenAnimeMappedWithName_isSame() {
        Assert.assertEquals(animeHomeUiList.first().name, topAnimeEntities.first().name)
    }

    @Test
    fun description_whenAnimeMapped_isSame() {
        Assert.assertEquals(animeHomeUiList.first().description, topAnimeEntities.first().description)
    }

    @Test
    fun id_whenAnimeMapped_isSame() {
        Assert.assertEquals(animeHomeUiList.first().id, topAnimeEntities.first().id)
    }

    @Test
    fun lastItemName_whenAnimeMapped_isSame() {
        Assert.assertEquals(animeHomeUiList.last().name, topAnimeEntities.last().name)
    }
}