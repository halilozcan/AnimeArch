package com.halilozcan.animearch.data.repository

import com.halilozcan.animearch.data.NetworkResponseState
import com.halilozcan.animearch.data.dto.single.SingleCharacterResponse
import com.halilozcan.animearch.data.dto.top.TopAnimeCharacterResponse
import com.halilozcan.animearch.data.source.RemoteDataSource
import com.halilozcan.animearch.di.coroutine.IoDispatcher
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