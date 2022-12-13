package com.halilozcan.animearch.core.domain.usecase.top

import app.cash.turbine.test
import com.google.common.truth.Truth
import com.halilozcan.animearch.core.common.NetworkResponseState
import kotlinx.coroutines.runBlocking
import org.junit.Test

internal class GetTopCharacterUseCaseTest {

    private val getTopCharacterUseCase = FakeGetTopCharacterUseCase()

    @Test
    fun networkState_whenStateLoading_returnLoading() {
        runBlocking {
            getTopCharacterUseCase().test {
                Truth.assertThat(awaitItem()).isInstanceOf(NetworkResponseState.Loading::class.java)
                cancelAndIgnoreRemainingEvents()
            }
        }
    }

    @Test
    fun networkState_whenStateLoadingAndSuccess_returnLoadingAndSuccessSequentially() {
        runBlocking {
            getTopCharacterUseCase().test {
                Truth.assertThat(awaitItem()).isInstanceOf(NetworkResponseState.Loading::class.java)
                Truth.assertThat(awaitItem()).isInstanceOf(NetworkResponseState.Success::class.java)
                awaitComplete()
            }
        }
    }

    @Test
    fun networkState_whenStateLoadingAndError_returnError() {
        runBlocking {
            getTopCharacterUseCase.updateShowError(true)
            getTopCharacterUseCase().test {
                Truth.assertThat(awaitItem()).isInstanceOf(NetworkResponseState.Loading::class.java)
                Truth.assertThat(awaitItem()).isInstanceOf(NetworkResponseState.Error::class.java)
                awaitComplete()
            }
        }
    }
}