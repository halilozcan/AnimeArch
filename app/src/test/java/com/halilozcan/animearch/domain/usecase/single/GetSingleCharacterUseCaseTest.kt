package com.halilozcan.animearch.domain.usecase.single

import app.cash.turbine.test
import com.google.common.truth.Truth
import com.halilozcan.animearch.data.NetworkResponseState
import com.halilozcan.animearch.singleAnimePathId
import kotlinx.coroutines.runBlocking
import org.junit.Test


internal class GetSingleCharacterUseCaseTest {

    private val getSingleCharacterUseCase = FakeGetSingleCharacterUseCase()

    @Test
    fun networkState_whenStateLoading_returnLoading() {
        runBlocking {
            getSingleCharacterUseCase(singleAnimePathId).test {
                Truth.assertThat(awaitItem()).isInstanceOf(NetworkResponseState.Loading::class.java)
                cancelAndIgnoreRemainingEvents()
            }
        }
    }

    @Test
    fun networkState_whenStateLoadingAndSuccess_returnLoadingAndSuccessSequentially() {
        runBlocking {
            getSingleCharacterUseCase(singleAnimePathId).test {
                Truth.assertThat(awaitItem()).isInstanceOf(NetworkResponseState.Loading::class.java)
                Truth.assertThat(awaitItem()).isInstanceOf(NetworkResponseState.Success::class.java)
                awaitComplete()
            }
        }
    }

    @Test
    fun networkState_whenStateLoadingAndError_returnError() {
        runBlocking {
            getSingleCharacterUseCase.updateShowError(true)
            getSingleCharacterUseCase(singleAnimePathId).test {
                Truth.assertThat(awaitItem()).isInstanceOf(NetworkResponseState.Loading::class.java)
                Truth.assertThat(awaitItem()).isInstanceOf(NetworkResponseState.Error::class.java)
                awaitComplete()
            }
        }
    }
}