package com.halilozcan.animearch.domain.usecase

import com.halilozcan.animearch.data.NetworkResponseState
import com.halilozcan.animearch.data.dto.single.AnimeCharacter
import com.halilozcan.animearch.data.repository.AnimeRepository
import com.halilozcan.animearch.domain.entity.SingleAnimeEntity
import com.halilozcan.animearch.domain.mapper.AnimeBaseMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetSingleCharacterUseCase @Inject constructor(
    private val repository: AnimeRepository,
    private val mapper: AnimeBaseMapper<AnimeCharacter, SingleAnimeEntity>
) {
    operator fun invoke(id: String): Flow<NetworkResponseState<SingleAnimeEntity>> = flow {
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