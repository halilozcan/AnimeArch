package com.halilozcan.animearch.data.dto.single


import com.google.gson.annotations.SerializedName

data class Person(
    @SerializedName("images")
    val images: ImagesXXX?,
    @SerializedName("mal_id")
    val malId: Int?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("url")
    val url: String?
)