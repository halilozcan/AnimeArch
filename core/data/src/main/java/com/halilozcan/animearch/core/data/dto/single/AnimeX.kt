package com.halilozcan.animearch.core.data.dto.single


import com.google.gson.annotations.SerializedName

data class AnimeX(
    @SerializedName("images")
    val images: Images?,
    @SerializedName("mal_id")
    val malId: Int?,
    @SerializedName("title")
    val title: String?,
    @SerializedName("url")
    val url: String?
)