package com.halilozcan.animearch.core.data.di

import com.halilozcan.animearch.core.data.dto.single.AnimeCharacter
import com.halilozcan.animearch.core.data.dto.top.Anime
import com.halilozcan.animearch.core.data.mapper.SingleAnimeEntityMapper
import com.halilozcan.animearch.core.data.mapper.TopAnimeEntityMapper
import com.halilozcan.animearch.core.domain.entity.SingleAnimeEntity
import com.halilozcan.animearch.core.domain.entity.TopAnimeEntity
import com.halilozcan.animearch.core.domain.mapper.AnimeBaseMapper
import com.halilozcan.animearch.core.domain.mapper.AnimeListMapper
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
}