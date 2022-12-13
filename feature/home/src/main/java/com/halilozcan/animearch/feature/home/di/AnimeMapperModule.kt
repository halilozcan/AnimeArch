package com.halilozcan.animearch.feature.home.di

import com.halilozcan.animearch.core.common.AnimeHomeUiData
import com.halilozcan.animearch.core.domain.entity.TopAnimeEntity
import com.halilozcan.animearch.core.domain.mapper.AnimeListMapper
import com.halilozcan.animearch.feature.home.AnimeHomeUiMapper
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
    abstract fun bindHomeAnimeUiMapper(animeUiDataMapper: AnimeHomeUiMapper): AnimeListMapper<TopAnimeEntity, AnimeHomeUiData>
}