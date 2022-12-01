package com.halilozcan.animearch.di.mapper

import com.halilozcan.animearch.data.dto.single.AnimeCharacter
import com.halilozcan.animearch.data.dto.top.Anime
import com.halilozcan.animearch.domain.entity.SingleAnimeEntity
import com.halilozcan.animearch.domain.entity.TopAnimeEntity
import com.halilozcan.animearch.domain.mapper.AnimeBaseMapper
import com.halilozcan.animearch.domain.mapper.AnimeListMapper
import com.halilozcan.animearch.domain.mapper.SingleAnimeEntityMapper
import com.halilozcan.animearch.domain.mapper.TopAnimeEntityMapper
import com.halilozcan.animearch.ui.AnimeDetailUiData
import com.halilozcan.animearch.ui.AnimeHomeUiData
import com.halilozcan.animearch.ui.detail.AnimeDetailUiMapper
import com.halilozcan.animearch.ui.home.AnimeHomeUiMapper
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
abstract class AnimeMapperModule {

    @Binds
    @ViewModelScoped
    abstract fun bindTopAnimeEntityMapper(animeEntityMapper: TopAnimeEntityMapper): AnimeListMapper<Anime, TopAnimeEntity>

    @Binds
    @ViewModelScoped
    abstract fun bindSingleAnimeEntityMapper(animeEntityMapper: SingleAnimeEntityMapper): AnimeBaseMapper<AnimeCharacter, SingleAnimeEntity>

    @Binds
    @ViewModelScoped
    abstract fun bindHomeAnimeUiMapper(animeUiDataMapper: AnimeHomeUiMapper): AnimeListMapper<TopAnimeEntity, AnimeHomeUiData>

    @Binds
    @ViewModelScoped
    abstract fun bindDetailAnimeUiMapper(animeUiDataMapper: AnimeDetailUiMapper): AnimeBaseMapper<SingleAnimeEntity, AnimeDetailUiData>
}