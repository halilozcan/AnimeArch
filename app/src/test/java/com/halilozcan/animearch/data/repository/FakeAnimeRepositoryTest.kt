package com.halilozcan.animearch.data.repository

import com.google.common.truth.Truth.assertThat
import com.halilozcan.animearch.data.NetworkResponseState
import com.halilozcan.animearch.singleAnimeCharacterResponse
import com.halilozcan.animearch.singleAnimePathId
import com.halilozcan.animearch.topAnimeCharacterResponse
import kotlinx.coroutines.runBlocking
import okio.IOException
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

/**
 * Faking any element is useful for mocking that element
 */
internal class FakeAnimeRepositoryTest {

    @Mock
    private lateinit var fakeAnimeRepository: FakeAnimeRepository

    @Before
    fun setup() {
        MockitoAnnotations.openMocks(this)
    }

    /**
     * TopAnimeCharacters Test
     */
    @Test
    fun topAnimeCharacterResponse_whenRemoteDataSourceReturnSuccess_returnSuccess() {
        runBlocking {
            Mockito.`when`(fakeAnimeRepository.getTopAnimeCharacters())
                .thenReturn(NetworkResponseState.Success(topAnimeCharacterResponse))
            val state = fakeAnimeRepository.getTopAnimeCharacters()
            assertThat(state).isInstanceOf(NetworkResponseState.Success::class.java)
        }
    }

    @Test
    fun topAnimeCharacterResponse_whenRemoteDataSourceReturnError_returnError() {
        runBlocking {
            fakeAnimeRepository.updateShowErrorTopAnimeCharacterResponse(true)
            Mockito.`when`(fakeAnimeRepository.getTopAnimeCharacters())
                .thenReturn(NetworkResponseState.Error(IOException()))
            val state = fakeAnimeRepository.getTopAnimeCharacters()
            assertThat(state).isInstanceOf(NetworkResponseState.Error::class.java)
        }
    }

    /**
     * SingleAnimeCharacter Test
     */
    @Test
    fun singleAnimeCharacterResponse_whenRemoteDataSourceReturnSuccess_returnSuccess() {
        runBlocking {
            Mockito.`when`(fakeAnimeRepository.getSingleCharacter(singleAnimePathId))
                .thenReturn(NetworkResponseState.Success(singleAnimeCharacterResponse))
            val state = fakeAnimeRepository.getSingleCharacter(singleAnimePathId)
            assertThat(state).isInstanceOf(NetworkResponseState.Success::class.java)
        }
    }

    @Test
    fun singleAnimeCharacterResponse_whenRemoteDataSourceReturnError_returnError() {
        runBlocking {
            fakeAnimeRepository.updateShowErrorSingleAnimeCharacterResponse(true)
            Mockito.`when`(fakeAnimeRepository.getSingleCharacter(singleAnimePathId))
                .thenReturn(NetworkResponseState.Error(IOException()))
            val state = fakeAnimeRepository.getSingleCharacter(singleAnimePathId)
            assertThat(state).isInstanceOf(NetworkResponseState.Error::class.java)
        }
    }
}