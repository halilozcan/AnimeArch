package com.halilozcan.animearch.core.data.di

import com.halilozcan.animearch.core.data.repository.AnimeRepositoryImpl
import com.halilozcan.animearch.core.domain.repository.AnimeRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
abstract class AnimeRepositoryModule {
    @Binds
    @ViewModelScoped
    abstract fun bindRepository(animeRepositoryImpl: AnimeRepositoryImpl): AnimeRepository
}