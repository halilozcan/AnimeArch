package com.halilozcan.animearch.core.data.dto.single


import com.google.gson.annotations.SerializedName

data class Anime(
    @SerializedName("anime")
    val anime: AnimeX?,
    @SerializedName("role")
    val role: String?
)