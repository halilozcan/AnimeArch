package com.halilozcan.animearch.ui

import androidx.navigation.NavType
import androidx.navigation.navArgument

interface AnimeDestination {
    val route: String
}

object Home : AnimeDestination {
    override val route: String
        get() = "home"
}

object Detail : AnimeDestination {
    override val route: String
        get() = "detail"
    const val idArg = "id"
    val routeWithArgs = "$route/{$idArg}"
    val arguments = listOf(
        navArgument(idArg) {
            type = NavType.StringType
        }
    )
}