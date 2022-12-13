package com.halilozcan.animearch.core.data.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

@InstallIn(ViewModelComponent::class)
@Module
object CoroutineDispatchersModule {

    @IoDispatcher
    @Provides
    @ViewModelScoped
    fun providesIoDispatcher(): CoroutineDispatcher = Dispatchers.IO
}
