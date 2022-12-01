package com.halilozcan.animearch.ui.detail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun NameSection(name: String, kanjiName: String, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.padding(horizontal = 16.dp)
    ) {
        Text(text = name)
        Text(text = kanjiName)
    }
}