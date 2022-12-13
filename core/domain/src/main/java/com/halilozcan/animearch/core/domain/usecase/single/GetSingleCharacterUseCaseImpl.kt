package com.halilozcan.animearch.core.domain.usecase.single

import com.halilozcan.animearch.core.common.NetworkResponseState
import com.halilozcan.animearch.core.data.dto.single.AnimeCharacter
import com.halilozcan.animearch.core.data.repository.AnimeRepository
import com.halilozcan.animearch.core.domain.entity.SingleAnimeEntity
import com.halilozcan.animearch.core.domain.mapper.AnimeBaseMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetSingleCharacterUseCaseImpl @Inject constructor(
    private val repository: AnimeRepository,
    private val mapper: AnimeBaseMapper<AnimeCharacter, SingleAnimeEntity>
) : GetSingleCharacterUseCase {

    override operator fun invoke(id: String): Flow<NetworkResponseState<SingleAnimeEntity>> = flow {
        emit(NetworkResponseState.Loading)

        when (val response = repository.getSingleCharacter(id)) {
            is NetworkResponseState.Error -> {
                emit(response)
            }
            is NetworkResponseState.Success -> {
                emit(NetworkResponseState.Success(mapper.map(response.result.data!!)))
            }
            else -> Unit
        }
    }
}