package com.halilozcan.animearch.core.data.dto.single


import com.google.gson.annotations.SerializedName

data class ImagesX(
    @SerializedName("jpg")
    val jpg: JpgX?,
    @SerializedName("webp")
    val webp: WebpX?
)