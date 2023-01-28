package com.halilozcan.animearch.core.domain.usecase.top

import com.halilozcan.animearch.core.common.NetworkResponseState
import com.halilozcan.animearch.core.domain.entity.TopAnimeEntity
import com.halilozcan.animearch.core.domain.repository.AnimeRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetTopCharacterUseCaseImpl @Inject constructor(
    private val repository: AnimeRepository
) : GetTopCharacterUseCase {
    override operator fun invoke(): Flow<NetworkResponseState<List<TopAnimeEntity>>> = repository.getTopAnimeCharacters()
}