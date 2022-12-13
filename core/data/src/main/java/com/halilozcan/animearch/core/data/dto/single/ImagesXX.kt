package com.halilozcan.animearch.core.data.dto.single


import com.google.gson.annotations.SerializedName

data class ImagesXX(
    @SerializedName("jpg")
    val jpg: Jpg?,
    @SerializedName("webp")
    val webp: WebpX?
)