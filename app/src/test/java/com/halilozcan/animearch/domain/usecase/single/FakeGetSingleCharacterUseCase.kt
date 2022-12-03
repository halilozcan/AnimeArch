package com.halilozcan.animearch.domain.usecase.single

import com.halilozcan.animearch.data.NetworkResponseState
import com.halilozcan.animearch.domain.entity.SingleAnimeEntity
import com.halilozcan.animearch.singleAnimeEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okio.IOException

class FakeGetSingleCharacterUseCase {

    private var showError = false

    fun updateShowError(showError: Boolean) {
        this.showError = showError
    }

    operator fun invoke(id: String): Flow<NetworkResponseState<SingleAnimeEntity>> = flow {
        emit(NetworkResponseState.Loading)

        if (showError) {
            emit(NetworkResponseState.Error(IOException()))
        } else {
            emit(NetworkResponseState.Success(singleAnimeEntity))
        }
    }
}