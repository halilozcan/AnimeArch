package com.halilozcan.animearch.core.domain.mapper

import com.halilozcan.animearch.core.domain.entity.TopAnimeEntity
import com.halilozcan.animearch.core.domain.topAnimeList
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

internal class TopAnimeEntityMapperTest {

    private val topAnimeEntityMapper: TopAnimeEntityMapper = TopAnimeEntityMapper()

    private lateinit var topAnimeEntities: List<TopAnimeEntity>

    @Before
    fun setup() {
        topAnimeEntities = topAnimeEntityMapper.map(topAnimeList)
    }

    @Test
    fun animeListSize_whenAnimeMapped_isSameSize() {
        assertEquals(topAnimeEntities.size, topAnimeList.size)
    }

    @Test
    fun name_whenAnimeMappedWithName_isSame() {
        assertEquals(topAnimeEntities.first().name, topAnimeList.first().name)
    }

    @Test
    fun description_whenAnimeMapped_isSame() {
        assertEquals(topAnimeEntities.first().description, topAnimeList.first().about)
    }

    @Test
    fun id_whenAnimeMapped_isSame() {
        assertEquals(topAnimeEntities.first().id, topAnimeList.first().malId.toString())
    }

    @Test
    fun lastItemName_whenAnimeMapped_isSame() {
        assertEquals(topAnimeEntities.last().name, topAnimeList.last().name)
    }
}