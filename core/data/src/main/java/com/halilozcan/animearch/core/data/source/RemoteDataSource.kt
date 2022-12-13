package com.halilozcan.animearch.core.data.source

import com.halilozcan.animearch.core.data.dto.single.SingleCharacterResponse
import com.halilozcan.animearch.core.data.dto.top.TopAnimeCharacterResponse

interface RemoteDataSource {

    suspend fun getTopAnimeCharacters(): com.halilozcan.animearch.core.common.NetworkResponseState<TopAnimeCharacterResponse>
    suspend fun getSingleCharacter(id: String): com.halilozcan.animearch.core.common.NetworkResponseState<SingleCharacterResponse>
}