package com.halilozcan.animearch.ui

sealed class ScreenState<out T : Any> {
    object Loading : ScreenState<Nothing>()
    data class Error(val message: String) : ScreenState<Nothing>()
    data class Success<out T : Any>(val uiData: T) : ScreenState<T>()
}

data class AnimeHomeUiData(
    val id: String,
    val name: String,
    val description: String,
    val imageUrl: String
)

data class AnimeDetailUiData(
    val name: String,
    val nameKanji: String,
    val description: String,
    val imageUrl: String,
    val favorites: Int,
)