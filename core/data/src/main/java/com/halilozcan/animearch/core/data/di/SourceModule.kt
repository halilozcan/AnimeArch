package com.halilozcan.animearch.core.data.di

import com.halilozcan.animearch.core.data.source.RemoteDataSource
import com.halilozcan.animearch.core.data.source.RemoteDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
abstract class SourceModule {


    @Binds
    @ViewModelScoped
    abstract fun bindRemoteDataSource(
        remoteDataSourceImpl: RemoteDataSourceImpl
    ): RemoteDataSource
}