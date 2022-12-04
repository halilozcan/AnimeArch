package com.halilozcan.animearch.domain.usecase.top

import com.halilozcan.animearch.data.NetworkResponseState
import com.halilozcan.animearch.domain.entity.TopAnimeEntity
import kotlinx.coroutines.flow.Flow

interface GetTopCharacterUseCase {
    operator fun invoke(): Flow<NetworkResponseState<List<TopAnimeEntity>>>
}