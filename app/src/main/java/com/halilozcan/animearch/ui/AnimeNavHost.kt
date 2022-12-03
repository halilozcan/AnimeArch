package com.halilozcan.animearch.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.halilozcan.animearch.ui.detail.DetailRoute
import com.halilozcan.animearch.ui.home.HomeRoute

@Composable
fun AnimeNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(navController = navController, startDestination = Home.route, modifier = modifier) {
        composable(route = Home.route) {
            HomeRoute(onAnimeClicked = {
                val route = "${Detail.route}/${it.id}"
                navController.navigate(route = route)
            })
        }

        composable(
            route = Detail.routeWithArgs,
            arguments = Detail.arguments
        ) {
            DetailRoute()
        }
    }
}