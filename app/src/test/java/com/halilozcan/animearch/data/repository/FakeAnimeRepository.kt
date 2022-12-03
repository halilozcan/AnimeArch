package com.halilozcan.animearch.data.repository

import com.halilozcan.animearch.animeTopCharacterResponse
import com.halilozcan.animearch.data.NetworkResponseState
import com.halilozcan.animearch.data.dto.single.SingleCharacterResponse
import com.halilozcan.animearch.data.dto.top.TopAnimeCharacterResponse
import okio.IOException

class FakeAnimeRepository : AnimeRepository {

    private var showError = false

    fun updateShowError(showError: Boolean) {
        this.showError = showError
    }

    override suspend fun getTopAnimeCharacters(): NetworkResponseState<TopAnimeCharacterResponse> {
        return if (showError) {
            NetworkResponseState.Error(IOException())
        } else {
            NetworkResponseState.Success(animeTopCharacterResponse)
        }
    }

    override suspend fun getSingleCharacter(id: String): NetworkResponseState<SingleCharacterResponse> {
        return NetworkResponseState.Error(IOException())
    }
}