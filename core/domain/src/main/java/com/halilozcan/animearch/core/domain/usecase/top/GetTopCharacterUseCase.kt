package com.halilozcan.animearch.core.domain.usecase.top

import com.halilozcan.animearch.core.common.NetworkResponseState
import com.halilozcan.animearch.core.domain.entity.TopAnimeEntity
import kotlinx.coroutines.flow.Flow

interface GetTopCharacterUseCase {
    operator fun invoke(): Flow<NetworkResponseState<List<TopAnimeEntity>>>
}