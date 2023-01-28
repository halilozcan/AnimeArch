package com.halilozcan.animearch.core.data.repository

import com.halilozcan.animearch.core.common.NetworkResponseState
import com.halilozcan.animearch.core.data.di.IoDispatcher
import com.halilozcan.animearch.core.data.dto.single.AnimeCharacter
import com.halilozcan.animearch.core.data.dto.top.Anime
import com.halilozcan.animearch.core.data.mapResponse
import com.halilozcan.animearch.core.data.source.RemoteDataSource
import com.halilozcan.animearch.core.domain.entity.SingleAnimeEntity
import com.halilozcan.animearch.core.domain.entity.TopAnimeEntity
import com.halilozcan.animearch.core.domain.mapper.AnimeBaseMapper
import com.halilozcan.animearch.core.domain.mapper.AnimeListMapper
import com.halilozcan.animearch.core.domain.repository.AnimeRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class AnimeRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO,
    private val singleAnimeMapper: AnimeBaseMapper<AnimeCharacter, SingleAnimeEntity>,
    private val topAnimeEntityMapper: AnimeListMapper<Anime, TopAnimeEntity>
) : AnimeRepository {

    override fun getTopAnimeCharacters(): Flow<NetworkResponseState<List<TopAnimeEntity>>> =
        remoteDataSource.getTopAnimeCharacters().map {
            it.mapResponse { topAnimeEntityMapper.map(data) }
        }


    override fun getSingleCharacter(id: String): Flow<NetworkResponseState<SingleAnimeEntity>> =
        remoteDataSource.getSingleCharacter(id).map {
            it.mapResponse { singleAnimeMapper.map(data!!) }
        }
}