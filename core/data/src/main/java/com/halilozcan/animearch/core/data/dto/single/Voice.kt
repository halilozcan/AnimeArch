package com.halilozcan.animearch.core.data.dto.single


import com.google.gson.annotations.SerializedName

data class Voice(
    @SerializedName("language")
    val language: String?,
    @SerializedName("person")
    val person: Person?
)