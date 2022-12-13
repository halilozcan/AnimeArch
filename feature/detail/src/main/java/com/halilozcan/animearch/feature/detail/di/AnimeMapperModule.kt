package com.halilozcan.animearch.feature.detail.di

import com.halilozcan.animearch.core.common.AnimeDetailUiData
import com.halilozcan.animearch.core.domain.entity.SingleAnimeEntity
import com.halilozcan.animearch.core.domain.mapper.AnimeBaseMapper
import com.halilozcan.animearch.feature.detail.AnimeDetailUiMapper
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
    abstract fun bindDetailAnimeUiMapper(animeUiDataMapper: AnimeDetailUiMapper): AnimeBaseMapper<SingleAnimeEntity, AnimeDetailUiData>
}