package com.halilozcan.animearch.core.data.repository

import com.halilozcan.animearch.core.common.NetworkResponseState
import com.halilozcan.animearch.core.data.dto.single.SingleCharacterResponse
import com.halilozcan.animearch.core.data.dto.top.TopAnimeCharacterResponse

interface AnimeRepository {
    suspend fun getTopAnimeCharacters(): NetworkResponseState<TopAnimeCharacterResponse>
    suspend fun getSingleCharacter(id: String): NetworkResponseState<SingleCharacterResponse>
}