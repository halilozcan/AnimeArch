package com.halilozcan.animearch.core.data.repository

import app.cash.turbine.test
import com.google.common.truth.Truth
import com.halilozcan.animearch.core.common.NetworkResponseState
import com.halilozcan.animearch.core.data.mapper.SingleAnimeEntityMapper
import com.halilozcan.animearch.core.data.mapper.TopAnimeEntityMapper
import com.halilozcan.animearch.core.data.singleAnimeCharacterResponse
import com.halilozcan.animearch.core.data.singleAnimePathId
import com.halilozcan.animearch.core.data.source.RemoteDataSource
import com.halilozcan.animearch.core.data.source.RemoteDataSourceImpl
import com.halilozcan.animearch.core.data.topAnimeCharacterResponse
import com.halilozcan.animearch.core.domain.repository.AnimeRepository
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

internal class AnimeRepositoryTest {

    @Mock
    private lateinit var animeApi: com.halilozcan.animearch.core.data.api.AnimeApi

    private lateinit var remoteDataSource: RemoteDataSource
    private lateinit var animeRepository: AnimeRepository

    @Before
    fun setup() {
        MockitoAnnotations.openMocks(this)
        remoteDataSource = RemoteDataSourceImpl(animeApi)
        animeRepository = AnimeRepositoryImpl(
            remoteDataSource,
            singleAnimeMapper = SingleAnimeEntityMapper(),
            topAnimeEntityMapper = TopAnimeEntityMapper()
        )
    }

    /**
     * TopAnimeCharacters Test
     */
    @Test
    fun topAnimaCharactersResponse_whenRemoteDataSourceReturnSuccess_returnSuccess() {
        runBlocking {
            Mockito.`when`(animeApi.getTopCharacters()).thenReturn(topAnimeCharacterResponse)
            animeRepository.getTopAnimeCharacters().test {
                Truth.assertThat(awaitItem()).isInstanceOf(NetworkResponseState.Loading::class.java)
                Truth.assertThat(awaitItem()).isInstanceOf(NetworkResponseState.Success::class.java)
                awaitComplete()
            }
        }
    }

    @Test
    fun topAnimaCharactersResponse_whenRemoteDataSourceReturnError_returnError() {
        runBlocking {
            Mockito.`when`(animeApi.getTopCharacters()).thenReturn(null)
            animeRepository.getTopAnimeCharacters().test {
                Truth.assertThat(awaitItem()).isInstanceOf(NetworkResponseState.Loading::class.java)
                Truth.assertThat(awaitItem()).isInstanceOf(NetworkResponseState.Error::class.java)
                awaitComplete()
            }
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
            animeRepository.getSingleCharacter(singleAnimePathId).test {
                Truth.assertThat(awaitItem()).isInstanceOf(NetworkResponseState.Loading::class.java)
                Truth.assertThat(awaitItem()).isInstanceOf(NetworkResponseState.Success::class.java)
                awaitComplete()
            }
        }
    }

    @Test
    fun singleAnimeCharacterResponse_whenRemoteDataSourceReturnError_returnError() {
        runBlocking {
            Mockito.`when`(animeApi.getSingleCharacterFull(singleAnimePathId))
                .thenReturn(null)

            animeRepository.getSingleCharacter(singleAnimePathId).test {
                Truth.assertThat(awaitItem()).isInstanceOf(NetworkResponseState.Loading::class.java)
                Truth.assertThat(awaitItem()).isInstanceOf(NetworkResponseState.Error::class.java)
                awaitComplete()
            }
        }
    }
}