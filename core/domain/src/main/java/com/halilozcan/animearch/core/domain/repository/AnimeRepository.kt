package com.halilozcan.animearch.core.domain.repository

import com.halilozcan.animearch.core.common.NetworkResponseState
import com.halilozcan.animearch.core.domain.entity.SingleAnimeEntity
import com.halilozcan.animearch.core.domain.entity.TopAnimeEntity
import kotlinx.coroutines.flow.Flow

interface AnimeRepository {
    fun getTopAnimeCharacters(): Flow<NetworkResponseState<List<TopAnimeEntity>>>
    fun getSingleCharacter(id: String): Flow<NetworkResponseState<SingleAnimeEntity>>
}