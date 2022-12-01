package com.halilozcan.animearch.data.dto.top


import com.google.gson.annotations.SerializedName

data class TopAnimeCharacterResponse(
    @SerializedName("data")
    val data: List<Anime>,
    @SerializedName("pagination")
    val pagination: Pagination?
)