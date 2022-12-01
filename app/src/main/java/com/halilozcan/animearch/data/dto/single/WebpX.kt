package com.halilozcan.animearch.data.dto.single


import com.google.gson.annotations.SerializedName

data class WebpX(
    @SerializedName("image_url")
    val imageUrl: String?,
    @SerializedName("small_image_url")
    val smallImageUrl: String?
)