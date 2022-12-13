package com.halilozcan.animearch.core.data.di

import com.halilozcan.animearch.core.data.api.AnimeApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val ANIME_API_URL = "https://api.jikan.moe/v4/"

@Module
@InstallIn(ViewModelComponent::class)
object AnimeNetworkModule {

    @Provides
    @ViewModelScoped
    fun getInterceptor(): Interceptor {
        return HttpLoggingInterceptor().apply {
            setLevel(HttpLoggingInterceptor.Level.BODY)
        }
    }

    @Provides
    @ViewModelScoped
    fun getHttpClient(interceptor: Interceptor): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .build()
    }

    @Provides
    @ViewModelScoped
    fun provideAnimeApi(client: OkHttpClient): AnimeApi {
        return Retrofit.Builder()
            .baseUrl(ANIME_API_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
            .create(AnimeApi::class.java)
    }
}