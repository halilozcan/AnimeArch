package com.halilozcan.animearch.core.data.dto.single


import com.google.gson.annotations.SerializedName

data class Manga(
    @SerializedName("manga")
    val manga: MangaX?,
    @SerializedName("role")
    val role: String?
)