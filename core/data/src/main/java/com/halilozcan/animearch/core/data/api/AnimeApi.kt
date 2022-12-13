package com.halilozcan.animearch.core.data.api

import com.halilozcan.animearch.core.data.dto.single.SingleCharacterResponse
import com.halilozcan.animearch.core.data.dto.top.TopAnimeCharacterResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface AnimeApi {

    @GET("top/characters")
    suspend fun getTopCharacters(): TopAnimeCharacterResponse

    @GET("characters/{id}/full")
    suspend fun getSingleCharacterFull(@Path("id") id: String): SingleCharacterResponse
}