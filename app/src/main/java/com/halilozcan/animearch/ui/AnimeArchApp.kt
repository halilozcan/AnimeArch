package com.halilozcan.animearch.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.halilozcan.animearch.core.design.theme.AnimeArchTheme
import com.halilozcan.animearch.navigation.CoreFeatureNavigator
import com.halilozcan.animearch.navigation.navGraph.HomeNavGraph
import com.halilozcan.animearch.navigation.navGraph.RootNavGraph
import com.ramcosta.composedestinations.DestinationsNavHost
import com.ramcosta.composedestinations.navigation.dependency

@Composable
fun AnimeArchApp() {
    AnimeArchTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            val navController = rememberNavController()
            DestinationsNavHost(
                navGraph = RootNavGraph,
                navController = navController,
                startRoute = HomeNavGraph,
                dependenciesContainerBuilder = {
                    dependency(
                        CoreFeatureNavigator(
                            navController = navController
                        )
                    )
                }
            )
        }
    }
}