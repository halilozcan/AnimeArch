package com.halilozcan.animearch.data.source

import com.google.common.truth.Truth.assertThat
import com.halilozcan.animearch.animeTopCharacterResponse
import com.halilozcan.animearch.data.NetworkResponseState
import com.halilozcan.animearch.data.api.AnimeApi
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

internal class RemoteDataSourceTest {

    @Mock
    private lateinit var animeApi: AnimeApi

    private lateinit var remoteDataSource: RemoteDataSourceImpl

    @Before
    fun setup() {
        MockitoAnnotations.openMocks(this)
        remoteDataSource = RemoteDataSourceImpl(animeApi)
    }

    @Test
    fun response_whenApiReturnSuccess_isResponseStateSuccess() {
        runBlocking {
            Mockito.`when`(animeApi.getTopCharacters()).thenReturn(animeTopCharacterResponse)
            val response = remoteDataSource.getTopAnimeCharacters()
            assertThat(response).isInstanceOf(NetworkResponseState.Success::class.java)
        }
    }

    @Test
    fun response_whenApiReturnNull_isResponseStateError() {
        runBlocking {
            Mockito.`when`(animeApi.getTopCharacters()).thenReturn(null)
            val response = remoteDataSource.getTopAnimeCharacters()
            assertThat(response).isInstanceOf(NetworkResponseState.Error::class.java)
        }
    }
}