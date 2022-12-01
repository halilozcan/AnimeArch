package com.halilozcan.animearch.data.dto.top


import com.google.gson.annotations.SerializedName

data class Items(
    @SerializedName("count")
    val count: Int?,
    @SerializedName("per_page")
    val perPage: Int?,
    @SerializedName("total")
    val total: Int?
)