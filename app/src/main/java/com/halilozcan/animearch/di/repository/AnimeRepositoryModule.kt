package com.halilozcan.animearch.di.repository

import com.halilozcan.animearch.data.repository.AnimeRepository
import com.halilozcan.animearch.data.repository.AnimeRepositoryImpl
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