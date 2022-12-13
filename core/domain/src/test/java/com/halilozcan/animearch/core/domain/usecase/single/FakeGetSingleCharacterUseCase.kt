package com.halilozcan.animearch.core.domain.usecase.single

import com.halilozcan.animearch.core.common.NetworkResponseState
import com.halilozcan.animearch.core.domain.entity.SingleAnimeEntity
import com.halilozcan.animearch.core.domain.singleAnimeEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException

class FakeGetSingleCharacterUseCase : GetSingleCharacterUseCase {

    private var showError = false

    fun updateShowError(showError: Boolean) {
        this.showError = showError
    }

    override operator fun invoke(id: String): Flow<NetworkResponseState<SingleAnimeEntity>> = flow {
        emit(NetworkResponseState.Loading)

        if (showError) {
            emit(NetworkResponseState.Error(IOException()))
        } else {
            emit(NetworkResponseState.Success(singleAnimeEntity))
        }
    }
}