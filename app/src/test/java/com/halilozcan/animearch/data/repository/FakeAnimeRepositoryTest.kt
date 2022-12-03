package com.halilozcan.animearch.data.repository

import com.google.common.truth.Truth.assertThat
import com.halilozcan.animearch.animeTopCharacterResponse
import com.halilozcan.animearch.data.NetworkResponseState
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

    @Test
    fun response_whenRemoteDataSourceReturnSuccess_returnSuccess() {
        runBlocking {
            Mockito.`when`(fakeAnimeRepository.getTopAnimeCharacters())
                .thenReturn(NetworkResponseState.Success(animeTopCharacterResponse))
            val state = fakeAnimeRepository.getTopAnimeCharacters()
            assertThat(state).isInstanceOf(NetworkResponseState.Success::class.java)
        }
    }

    @Test
    fun response_whenRemoteDataSourceReturnSuccess_returnError() {
        runBlocking {
            fakeAnimeRepository.updateShowError(true)
            Mockito.`when`(fakeAnimeRepository.getTopAnimeCharacters())
                .thenReturn(NetworkResponseState.Error(IOException()))
            val state = fakeAnimeRepository.getTopAnimeCharacters()
            assertThat(state).isInstanceOf(NetworkResponseState.Error::class.java)
        }
    }
}