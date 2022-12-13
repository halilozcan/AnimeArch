package com.halilozcan.animearch.core.data.dto.single


import com.google.gson.annotations.SerializedName

data class SingleCharacterResponse(
    @SerializedName("data")
    val data: AnimeCharacter?
)