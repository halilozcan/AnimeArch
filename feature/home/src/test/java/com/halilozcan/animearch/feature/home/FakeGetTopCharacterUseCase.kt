package com.halilozcan.animearch.feature.home

import com.halilozcan.animearch.core.common.NetworkResponseState
import com.halilozcan.animearch.core.domain.entity.TopAnimeEntity
import com.halilozcan.animearch.core.domain.usecase.top.GetTopCharacterUseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException

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