package com.halilozcan.animearch.data.dto.single


import com.google.gson.annotations.SerializedName

data class AnimeCharacter(
    @SerializedName("about")
    val about: String?,
    @SerializedName("anime")
    val anime: List<Anime>?,
    @SerializedName("favorites")
    val favorites: Int?,
    @SerializedName("images")
    val images: ImagesX?,
    @SerializedName("mal_id")
    val malId: Int?,
    @SerializedName("manga")
    val manga: List<Manga>?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("name_kanji")
    val nameKanji: String?,
    @SerializedName("nicknames")
    val nicknames: List<String>?,
    @SerializedName("url")
    val url: String?,
    @SerializedName("voices")
    val voices: List<Voice>?
)