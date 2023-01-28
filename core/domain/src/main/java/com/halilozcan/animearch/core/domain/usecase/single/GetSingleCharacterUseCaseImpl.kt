package com.halilozcan.animearch.core.domain.usecase.single

import com.halilozcan.animearch.core.common.NetworkResponseState
import com.halilozcan.animearch.core.domain.entity.SingleAnimeEntity
import com.halilozcan.animearch.core.domain.repository.AnimeRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetSingleCharacterUseCaseImpl @Inject constructor(
    private val repository: AnimeRepository
) : GetSingleCharacterUseCase {

    override operator fun invoke(id: String): Flow<NetworkResponseState<SingleAnimeEntity>> = repository.getSingleCharacter(id)
}