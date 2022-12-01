package com.halilozcan.animearch.data.dto.top


import com.google.gson.annotations.SerializedName

data class Anime(
    @SerializedName("about")
    val about: String?,
    @SerializedName("favorites")
    val favorites: Int?,
    @SerializedName("images")
    val images: Images?,
    @SerializedName("mal_id")
    val malId: Int?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("name_kanji")
    val nameKanji: String?,
    @SerializedName("nicknames")
    val nicknames: List<String?>?,
    @SerializedName("url")
    val url: String?
)