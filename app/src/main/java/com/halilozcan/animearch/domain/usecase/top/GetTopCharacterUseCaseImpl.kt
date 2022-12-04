package com.halilozcan.animearch.domain.usecase.top

import com.halilozcan.animearch.data.NetworkResponseState
import com.halilozcan.animearch.data.dto.top.Anime
import com.halilozcan.animearch.data.repository.AnimeRepository
import com.halilozcan.animearch.domain.entity.TopAnimeEntity
import com.halilozcan.animearch.domain.mapper.AnimeListMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetTopCharacterUseCaseImpl @Inject constructor(
    private val repository: AnimeRepository,
    private val mapper: AnimeListMapper<Anime, TopAnimeEntity>
) : GetTopCharacterUseCase {
    override operator fun invoke(): Flow<NetworkResponseState<List<TopAnimeEntity>>> = flow {
        emit(NetworkResponseState.Loading)

        when (val response = repository.getTopAnimeCharacters()) {
            is NetworkResponseState.Error -> {
                emit(response)
            }
            is NetworkResponseState.Success -> {
                emit(NetworkResponseState.Success(mapper.map(response.result.data)))
            }
            else -> Unit
        }
    }
}