package com.halilozcan.animearch.core.data.source

import app.cash.turbine.test
import com.google.common.truth.Truth.assertThat
import com.halilozcan.animearch.core.common.NetworkResponseState
import com.halilozcan.animearch.core.data.api.AnimeApi
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
    private lateinit var animeApi: AnimeApi

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
            remoteDataSource.getTopAnimeCharacters().test {
                assertThat(awaitItem()).isInstanceOf(NetworkResponseState.Loading::class.java)
                assertThat(awaitItem()).isInstanceOf(NetworkResponseState.Success::class.java)
                awaitComplete()
            }

        }
    }

    @Test
    fun topAnimeResponse_whenApiReturnNull_isResponseStateError() {
        runBlocking {
            Mockito.`when`(animeApi.getTopCharacters()).thenReturn(null)
            remoteDataSource.getTopAnimeCharacters().test {
                assertThat(awaitItem()).isInstanceOf(NetworkResponseState.Loading::class.java)
                assertThat(awaitItem()).isInstanceOf(NetworkResponseState.Error::class.java)
                awaitComplete()
            }
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

            remoteDataSource.getSingleCharacter(singleAnimePathId).test {
                assertThat(awaitItem()).isInstanceOf(NetworkResponseState.Loading::class.java)
                assertThat(awaitItem()).isInstanceOf(NetworkResponseState.Success::class.java)
                awaitComplete()
            }
        }
    }

    @Test
    fun singleAnimeResponse_whenApiReturnSuccess_isResponseStateError() {
        runBlocking {
            Mockito.`when`(animeApi.getSingleCharacterFull(singleAnimePathId)).thenReturn(null)
            remoteDataSource.getSingleCharacter(singleAnimePathId).test {
                assertThat(awaitItem()).isInstanceOf(NetworkResponseState.Loading::class.java)
                assertThat(awaitItem()).isInstanceOf(NetworkResponseState.Error::class.java)
                awaitComplete()
            }
        }
    }
}