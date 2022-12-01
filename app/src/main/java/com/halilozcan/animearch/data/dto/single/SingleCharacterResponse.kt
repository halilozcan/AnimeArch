package com.halilozcan.animearch.data.dto.single


import com.google.gson.annotations.SerializedName

data class SingleCharacterResponse(
    @SerializedName("data")
    val data: AnimeCharacter?
)