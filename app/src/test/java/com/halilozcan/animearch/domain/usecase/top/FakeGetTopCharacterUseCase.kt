package com.halilozcan.animearch.domain.usecase.top

import com.halilozcan.animearch.data.NetworkResponseState
import com.halilozcan.animearch.domain.entity.TopAnimeEntity
import com.halilozcan.animearch.topAnimeEntities
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okio.IOException

class FakeGetTopCharacterUseCase : GetTopCharacterUseCase {
    private var showError = false

    fun updateShowError(showError: Boolean) {
        this.showError = showError
    }

    override operator fun invoke(): Flow<NetworkResponseState<List<TopAnimeEntity>>> = flow {
        emit(NetworkResponseState.Loading)

        if (showError) {
            emit(NetworkResponseState.Error(IOException()))
        } else {
            emit(NetworkResponseState.Success(topAnimeEntities))
        }
    }
}