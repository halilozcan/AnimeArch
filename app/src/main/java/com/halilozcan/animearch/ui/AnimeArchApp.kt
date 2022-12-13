package com.halilozcan.animearch.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.halilozcan.animearch.core.design.theme.AnimeArchTheme
import com.halilozcan.animearch.navigation.AnimeNavHost

@Composable
fun AnimeArchApp() {
    AnimeArchTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            val navController = rememberNavController()
            AnimeNavHost(navController = navController)
        }
    }
}