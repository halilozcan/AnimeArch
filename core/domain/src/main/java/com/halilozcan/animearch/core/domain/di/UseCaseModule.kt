package com.halilozcan.animearch.core.domain.di

import com.halilozcan.animearch.core.domain.usecase.single.GetSingleCharacterUseCase
import com.halilozcan.animearch.core.domain.usecase.single.GetSingleCharacterUseCaseImpl
import com.halilozcan.animearch.core.domain.usecase.top.GetTopCharacterUseCase
import com.halilozcan.animearch.core.domain.usecase.top.GetTopCharacterUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
abstract class UseCaseModule {

    @Binds
    @ViewModelScoped
    abstract fun bindGetSingleCharacterUseCase(getSingleCharacterUseCaseImpl: GetSingleCharacterUseCaseImpl): GetSingleCharacterUseCase

    @Binds
    @ViewModelScoped
    abstract fun bindTopCharacterUseCase(getTopCharacterUseCaseImpl: GetTopCharacterUseCaseImpl): GetTopCharacterUseCase
}