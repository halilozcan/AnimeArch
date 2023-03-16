package com.halilozcan.animearch.navigation

import androidx.navigation.NavController
import com.halilozcan.animearch.feature.detail.destinations.DetailRouteDestination
import com.halilozcan.animearch.feature.home.HomeScreenNavigator
import com.halilozcan.animearch.navigation.navGraph.HomeNavGraph
import com.ramcosta.composedestinations.dynamic.within
import com.ramcosta.composedestinations.navigation.navigate

class CoreFeatureNavigator(
    private val navController: NavController
) : HomeScreenNavigator {

    override fun navigateToDetailScreen(id: String) {
        navController.navigate(DetailRouteDestination(id) within HomeNavGraph)
    }
}