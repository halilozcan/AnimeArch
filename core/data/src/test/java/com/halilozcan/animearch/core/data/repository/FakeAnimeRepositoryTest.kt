package com.halilozcan.animearch.core.data.repository

import app.cash.turbine.test
import com.google.common.truth.Truth
import com.halilozcan.animearch.core.common.NetworkResponseState
import com.halilozcan.animearch.core.data.singleAnimePathId
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations

/**
 * Faking any element is useful for mocking that element
 */
internal class FakeAnimeRepositoryTest {

    private val fakeAnimeRepository =  FakeAnimeRepository()

    /**
     * TopAnimeCharacters Test
     */
    @Test
    fun topAnimeCharacterResponse_whenRemoteDataSourceReturnSuccess_returnSuccess() {
        runBlocking {
            fakeAnimeRepository.getTopAnimeCharacters().test {
                Truth.assertThat(awaitItem()).isInstanceOf(NetworkResponseState.Loading::class.java)
                Truth.assertThat(awaitItem()).isInstanceOf(NetworkResponseState.Success::class.java)
                awaitComplete()
            }
        }
    }

    @Test
    fun topAnimeCharacterResponse_whenRemoteDataSourceReturnError_returnError() {
        runBlocking {
            fakeAnimeRepository.updateShowErrorTopAnimeCharacterResponse(true)
            fakeAnimeRepository.getTopAnimeCharacters().test {
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
            fakeAnimeRepository.getSingleCharacter(singleAnimePathId).test {
                Truth.assertThat(awaitItem()).isInstanceOf(NetworkResponseState.Loading::class.java)
                Truth.assertThat(awaitItem()).isInstanceOf(NetworkResponseState.Success::class.java)
                awaitComplete()
            }
        }
    }

    @Test
    fun singleAnimeCharacterResponse_whenRemoteDataSourceReturnError_returnError() {
        runBlocking {
            fakeAnimeRepository.updateShowErrorSingleAnimeCharacterResponse(true)
            fakeAnimeRepository.getSingleCharacter(singleAnimePathId).test {
                Truth.assertThat(awaitItem()).isInstanceOf(NetworkResponseState.Loading::class.java)
                Truth.assertThat(awaitItem()).isInstanceOf(NetworkResponseState.Error::class.java)
                awaitComplete()
            }
        }
    }
}