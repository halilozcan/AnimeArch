package com.halilozcan.animearch.core.domain.usecase.single

import com.halilozcan.animearch.core.common.NetworkResponseState
import com.halilozcan.animearch.core.domain.entity.SingleAnimeEntity
import kotlinx.coroutines.flow.Flow

interface GetSingleCharacterUseCase {
    operator fun invoke(id: String): Flow<NetworkResponseState<SingleAnimeEntity>>
}