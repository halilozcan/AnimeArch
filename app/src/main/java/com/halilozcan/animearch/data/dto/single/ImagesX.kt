package com.halilozcan.animearch.data.dto.single


import com.google.gson.annotations.SerializedName

data class ImagesX(
    @SerializedName("jpg")
    val jpg: JpgX?,
    @SerializedName("webp")
    val webp: WebpX?
)