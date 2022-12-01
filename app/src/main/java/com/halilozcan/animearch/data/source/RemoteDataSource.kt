package com.halilozcan.animearch.data.source

import com.halilozcan.animearch.data.NetworkResponseState
import com.halilozcan.animearch.data.dto.single.SingleCharacterResponse
import com.halilozcan.animearch.data.dto.top.TopAnimeCharacterResponse

interface RemoteDataSource {

    suspend fun getTopAnimeCharacters(): NetworkResponseState<TopAnimeCharacterResponse>
    suspend fun getSingleCharacter(id: String): NetworkResponseState<SingleCharacterResponse>
}