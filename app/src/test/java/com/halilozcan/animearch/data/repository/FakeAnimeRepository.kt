package com.halilozcan.animearch.data.repository

import com.halilozcan.animearch.data.NetworkResponseState
import com.halilozcan.animearch.data.dto.single.SingleCharacterResponse
import com.halilozcan.animearch.data.dto.top.TopAnimeCharacterResponse
import com.halilozcan.animearch.singleAnimeCharacterResponse
import com.halilozcan.animearch.topAnimeCharacterResponse
import okio.IOException

class FakeAnimeRepository : AnimeRepository {

    private var showErrorForTopAnimeCharacter = false
    private var showErrorForSingleAnimeCharacter = false

    fun updateShowErrorTopAnimeCharacterResponse(showError: Boolean) {
        this.showErrorForTopAnimeCharacter = showError
    }

    fun updateShowErrorSingleAnimeCharacterResponse(showError: Boolean) {
        this.showErrorForSingleAnimeCharacter = showError
    }

    override suspend fun getTopAnimeCharacters(): NetworkResponseState<TopAnimeCharacterResponse> {
        return if (showErrorForTopAnimeCharacter) {
            NetworkResponseState.Error(IOException())
        } else {
            NetworkResponseState.Success(topAnimeCharacterResponse)
        }
    }

    override suspend fun getSingleCharacter(id: String): NetworkResponseState<SingleCharacterResponse> {
        return if (showErrorForSingleAnimeCharacter) {
            NetworkResponseState.Error(IOException())
        } else {
            NetworkResponseState.Success(singleAnimeCharacterResponse)
        }
    }
}