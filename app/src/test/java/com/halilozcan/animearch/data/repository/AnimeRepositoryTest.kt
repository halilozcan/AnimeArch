package com.halilozcan.animearch.data.repository

import com.google.common.truth.Truth.assertThat
import com.halilozcan.animearch.animeTopCharacterResponse
import com.halilozcan.animearch.data.NetworkResponseState
import com.halilozcan.animearch.data.api.AnimeApi
import com.halilozcan.animearch.data.source.RemoteDataSource
import com.halilozcan.animearch.data.source.RemoteDataSourceImpl
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

internal class AnimeRepositoryTest {

    @Mock
    private lateinit var animeApi: AnimeApi

    private lateinit var remoteDataSource: RemoteDataSource
    private lateinit var animeRepository: AnimeRepository

    @Before
    fun setup() {
        MockitoAnnotations.openMocks(this)
        remoteDataSource = RemoteDataSourceImpl(animeApi)
        animeRepository = AnimeRepositoryImpl(remoteDataSource)
    }

    @Test
    fun response_whenRemoteDataSourceReturnSuccess_returnSuccess() {
        runBlocking {
            Mockito.`when`(animeApi.getTopCharacters())
                .thenReturn(animeTopCharacterResponse)
            val state = animeRepository.getTopAnimeCharacters()
            assertThat(state).isInstanceOf(NetworkResponseState.Success::class.java)
        }
    }

    @Test
    fun response_whenRemoteDataSourceReturnSuccess_returnError() {
        runBlocking {
            Mockito.`when`(animeApi.getTopCharacters())
                .thenReturn(null)
            val state = animeRepository.getTopAnimeCharacters()
            assertThat(state).isInstanceOf(NetworkResponseState.Error::class.java)
        }
    }
}