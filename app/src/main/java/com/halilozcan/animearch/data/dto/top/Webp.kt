package com.halilozcan.animearch.data.dto.top


import com.google.gson.annotations.SerializedName

data class Webp(
    @SerializedName("image_url")
    val imageUrl: String?,
    @SerializedName("small_image_url")
    val smallImageUrl: String?
)