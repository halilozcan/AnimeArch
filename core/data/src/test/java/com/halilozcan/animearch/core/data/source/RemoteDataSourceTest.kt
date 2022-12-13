package com.halilozcan.animearch.core.data.source

import com.google.common.truth.Truth.assertThat
import com.halilozcan.animearch.core.data.singleAnimeCharacterResponse
import com.halilozcan.animearch.core.data.singleAnimePathId
import com.halilozcan.animearch.core.data.topAnimeCharacterResponse
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

internal class RemoteDataSourceTest {

    @Mock
    private lateinit var animeApi: com.halilozcan.animearch.core.data.api.AnimeApi

    private lateinit var remoteDataSource: RemoteDataSourceImpl

    @Before
    fun setup() {
        MockitoAnnotations.openMocks(this)
        remoteDataSource = RemoteDataSourceImpl(animeApi)
    }

    /**
     * TopAnimeCharacters Test
     */
    @Test
    fun topAnimeResponse_whenApiReturnSuccess_isResponseStateSuccess() {
        runBlocking {
            Mockito.`when`(animeApi.getTopCharacters()).thenReturn(topAnimeCharacterResponse)
            val response = remoteDataSource.getTopAnimeCharacters()
            assertThat(response).isInstanceOf(com.halilozcan.animearch.core.common.NetworkResponseState.Success::class.java)
        }
    }

    @Test
    fun topAnimeResponse_whenApiReturnNull_isResponseStateError() {
        runBlocking {
            Mockito.`when`(animeApi.getTopCharacters()).thenReturn(null)
            val response = remoteDataSource.getTopAnimeCharacters()
            assertThat(response).isInstanceOf(com.halilozcan.animearch.core.common.NetworkResponseState.Error::class.java)
        }
    }

    /**
     * SingleAnimeCharacter Test
     */
    @Test
    fun singleAnimeResponse_whenApiReturnSuccess_isResponseStateSuccess() {
        runBlocking {
            Mockito.`when`(animeApi.getSingleCharacterFull(singleAnimePathId)).thenReturn(
                singleAnimeCharacterResponse
            )
            val response = remoteDataSource.getSingleCharacter(singleAnimePathId)
            assertThat(response).isInstanceOf(com.halilozcan.animearch.core.common.NetworkResponseState.Success::class.java)
        }
    }

    @Test
    fun singleAnimeResponse_whenApiReturnSuccess_isResponseStateError() {
        runBlocking {
            Mockito.`when`(animeApi.getSingleCharacterFull(singleAnimePathId)).thenReturn(null)
            val response = remoteDataSource.getSingleCharacter(singleAnimePathId)
            assertThat(response).isInstanceOf(com.halilozcan.animearch.core.common.NetworkResponseState.Error::class.java)
        }
    }
}