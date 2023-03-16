package com.halilozcan.animearch.navigation.navGraph


import com.ramcosta.composedestinations.spec.DestinationSpec
import com.ramcosta.composedestinations.spec.NavGraphSpec
import com.ramcosta.composedestinations.spec.Route

object RootNavGraph : NavGraphSpec {

    override val route: String = "root"

    override val startRoute: Route = HomeNavGraph

    override val nestedNavGraphs: List<NavGraphSpec> = listOf(HomeNavGraph)

    override val destinationsByRoute: Map<String, DestinationSpec<*>> = emptyMap()
}