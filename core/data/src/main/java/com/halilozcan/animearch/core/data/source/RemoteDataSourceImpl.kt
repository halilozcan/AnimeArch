package com.halilozcan.animearch.core.data.source

import com.halilozcan.animearch.core.common.NetworkResponseState
import com.halilozcan.animearch.core.data.api.AnimeApi
import com.halilozcan.animearch.core.data.dto.single.SingleCharacterResponse
import com.halilozcan.animearch.core.data.dto.top.TopAnimeCharacterResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor(private val api: AnimeApi) : RemoteDataSource {
    override fun getTopAnimeCharacters(): Flow<NetworkResponseState<TopAnimeCharacterResponse>> =
        flow {
            emit(NetworkResponseState.Loading)
            try {
                val response = api.getTopCharacters()
                emit(NetworkResponseState.Success(response))
            } catch (e: Exception) {
                emit(NetworkResponseState.Error(e))
            }
        }

    override fun getSingleCharacter(id: String): Flow<NetworkResponseState<SingleCharacterResponse>> =
        flow {
            emit(NetworkResponseState.Loading)
            try {
                val response = api.getSingleCharacterFull(id)
                emit(NetworkResponseState.Success(response))
            } catch (e: Exception) {
                emit(NetworkResponseState.Error(e))
            }
        }
}