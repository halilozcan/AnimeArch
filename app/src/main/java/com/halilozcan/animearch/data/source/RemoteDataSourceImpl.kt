package com.halilozcan.animearch.data.source

import com.halilozcan.animearch.data.NetworkResponseState
import com.halilozcan.animearch.data.api.AnimeApi
import com.halilozcan.animearch.data.dto.single.SingleCharacterResponse
import com.halilozcan.animearch.data.dto.top.TopAnimeCharacterResponse
import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor(private val api: AnimeApi) : RemoteDataSource {
    override suspend fun getTopAnimeCharacters(): NetworkResponseState<TopAnimeCharacterResponse> {
        return try {
            val response = api.getTopCharacters()
            NetworkResponseState.Success(response)
        } catch (e: Exception) {
            NetworkResponseState.Error(e)
        }
    }

    override suspend fun getSingleCharacter(id: String): NetworkResponseState<SingleCharacterResponse> {
        return try {
            val response = api.getSingleCharacterFull(id)
            NetworkResponseState.Success(response)
        } catch (e: Exception) {
            NetworkResponseState.Error(e)
        }
    }
}