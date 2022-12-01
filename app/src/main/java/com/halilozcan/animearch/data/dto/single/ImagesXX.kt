package com.halilozcan.animearch.data.dto.single


import com.google.gson.annotations.SerializedName

data class ImagesXX(
    @SerializedName("jpg")
    val jpg: Jpg?,
    @SerializedName("webp")
    val webp: WebpX?
)