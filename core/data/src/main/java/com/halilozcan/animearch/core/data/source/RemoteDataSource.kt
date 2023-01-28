package com.halilozcan.animearch.core.data.source

import com.halilozcan.animearch.core.common.NetworkResponseState
import com.halilozcan.animearch.core.data.dto.single.SingleCharacterResponse
import com.halilozcan.animearch.core.data.dto.top.TopAnimeCharacterResponse
import kotlinx.coroutines.flow.Flow

interface RemoteDataSource {
    fun getTopAnimeCharacters(): Flow<NetworkResponseState<TopAnimeCharacterResponse>>
    fun getSingleCharacter(id: String): Flow<NetworkResponseState<SingleCharacterResponse>>
}