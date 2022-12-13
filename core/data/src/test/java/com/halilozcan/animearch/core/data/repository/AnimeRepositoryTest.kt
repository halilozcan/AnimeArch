package com.halilozcan.animearch.core.data.repository

import com.google.common.truth.Truth.assertThat
import com.halilozcan.animearch.core.common.NetworkResponseState
import com.halilozcan.animearch.core.data.singleAnimeCharacterResponse
import com.halilozcan.animearch.core.data.singleAnimePathId
import com.halilozcan.animearch.core.data.source.RemoteDataSourceImpl
import com.halilozcan.animearch.core.data.topAnimeCharacterResponse
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

internal class AnimeRepositoryTest {

    @Mock
    private lateinit var animeApi: com.halilozcan.animearch.core.data.api.AnimeApi

    private lateinit var remoteDataSource: com.halilozcan.animearch.core.data.source.RemoteDataSource
    private lateinit var animeRepository: AnimeRepository

    @Before
    fun setup() {
        MockitoAnnotations.openMocks(this)
        remoteDataSource = RemoteDataSourceImpl(animeApi)
        animeRepository = AnimeRepositoryImpl(remoteDataSource)
    }

    /**
     * TopAnimeCharacters Test
     */
    @Test
    fun topAnimaCharactersResponse_whenRemoteDataSourceReturnSuccess_returnSuccess() {
        runBlocking {
            Mockito.`when`(animeApi.getTopCharacters())
                .thenReturn(topAnimeCharacterResponse)
            val state = animeRepository.getTopAnimeCharacters()
            assertThat(state).isInstanceOf(NetworkResponseState.Success::class.java)
        }
    }

    @Test
    fun topAnimaCharactersResponse_whenRemoteDataSourceReturnError_returnError() {
        runBlocking {
            Mockito.`when`(animeApi.getTopCharacters())
                .thenReturn(null)
            val state = animeRepository.getTopAnimeCharacters()
            assertThat(state).isInstanceOf(NetworkResponseState.Error::class.java)
        }
    }

    /**
     * SingleAnimeCharacter Test
     */
    @Test
    fun singleAnimeCharacterResponse_whenRemoteDataSourceReturnSuccess_returnSuccess() {
        runBlocking {
            Mockito.`when`(animeApi.getSingleCharacterFull(singleAnimePathId))
                .thenReturn(singleAnimeCharacterResponse)
            val state = animeRepository.getSingleCharacter(singleAnimePathId)
            assertThat(state).isInstanceOf(NetworkResponseState.Success::class.java)
        }
    }

    @Test
    fun singleAnimeCharacterResponse_whenRemoteDataSourceReturnError_returnError() {
        runBlocking {
            Mockito.`when`(animeApi.getSingleCharacterFull(singleAnimePathId))
                .thenReturn(null)
            val state = animeRepository.getSingleCharacter(singleAnimePathId)
            assertThat(state).isInstanceOf(NetworkResponseState.Error::class.java)
        }
    }
}