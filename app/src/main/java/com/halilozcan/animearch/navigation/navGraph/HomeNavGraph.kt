package com.halilozcan.animearch.navigation.navGraph

import com.halilozcan.animearch.feature.detail.destinations.DetailRouteDestination
import com.halilozcan.animearch.feature.home.destinations.HomeRouteDestination
import com.ramcosta.composedestinations.dynamic.routedIn
import com.ramcosta.composedestinations.spec.DestinationSpec
import com.ramcosta.composedestinations.spec.NavGraphSpec
import com.ramcosta.composedestinations.spec.Route

object HomeNavGraph : NavGraphSpec {
    override val route: String = "home"

    override val startRoute: Route = HomeRouteDestination routedIn this

    override val destinationsByRoute: Map<String, DestinationSpec<*>> = listOf(
        HomeRouteDestination,
        DetailRouteDestination
    ).routedIn(this)
        .associateBy { it.route }
}