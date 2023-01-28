package com.halilozcan.animearch.core.data.repository

import com.halilozcan.animearch.core.common.NetworkResponseState
import com.halilozcan.animearch.core.data.*
import com.halilozcan.animearch.core.domain.entity.SingleAnimeEntity
import com.halilozcan.animearch.core.domain.entity.TopAnimeEntity
import com.halilozcan.animearch.core.domain.repository.AnimeRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okio.IOException

class FakeAnimeRepository : AnimeRepository {

    private var showErrorForTopAnimeCharacter = false
    private var showErrorForSingleAnimeCharacter = false

    fun updateShowErrorTopAnimeCharacterResponse(showError: Boolean) {
        this.showErrorForTopAnimeCharacter = showError
    }

    fun updateShowErrorSingleAnimeCharacterResponse(showError: Boolean) {
        this.showErrorForSingleAnimeCharacter = showError
    }

    override fun getTopAnimeCharacters(): Flow<NetworkResponseState<List<TopAnimeEntity>>> = flow {
        emit(NetworkResponseState.Loading)
        if (showErrorForTopAnimeCharacter) {
            emit(NetworkResponseState.Error(IOException()))
        } else {
            emit(NetworkResponseState.Success(topAnimeEntities))
        }
    }

    override fun getSingleCharacter(id: String): Flow<NetworkResponseState<SingleAnimeEntity>> =
        flow {
            emit(NetworkResponseState.Loading)
            if (showErrorForSingleAnimeCharacter) {
                emit(NetworkResponseState.Error(IOException()))
            } else {
                emit(NetworkResponseState.Success(singleAnimeEntity))
            }
        }
}