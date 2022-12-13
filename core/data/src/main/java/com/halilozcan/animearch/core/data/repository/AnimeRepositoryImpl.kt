package com.halilozcan.animearch.core.data.repository

import com.halilozcan.animearch.core.common.NetworkResponseState
import com.halilozcan.animearch.core.data.di.IoDispatcher
import com.halilozcan.animearch.core.data.dto.single.SingleCharacterResponse
import com.halilozcan.animearch.core.data.dto.top.TopAnimeCharacterResponse
import com.halilozcan.animearch.core.data.source.RemoteDataSource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class AnimeRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
) :
    AnimeRepository {

    override suspend fun getTopAnimeCharacters(): NetworkResponseState<TopAnimeCharacterResponse> =
        withContext(ioDispatcher) {
            try {
                remoteDataSource.getTopAnimeCharacters()
            } catch (e: Exception) {
                NetworkResponseState.Error(e)
            }
        }

    override suspend fun getSingleCharacter(id: String): NetworkResponseState<SingleCharacterResponse> =
        withContext(ioDispatcher) {
            try {
                remoteDataSource.getSingleCharacter(id)
            } catch (e: Exception) {
                NetworkResponseState.Error(e)
            }
        }
}