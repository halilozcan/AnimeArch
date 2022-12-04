package com.halilozcan.animearch.domain.usecase.single

import com.halilozcan.animearch.data.NetworkResponseState
import com.halilozcan.animearch.domain.entity.SingleAnimeEntity
import kotlinx.coroutines.flow.Flow

interface GetSingleCharacterUseCase {
    operator fun invoke(id: String): Flow<NetworkResponseState<SingleAnimeEntity>>
}