package com.halilozcan.animearch.ui.detail

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun Description(
    description: String,
    isExpanded: Boolean,
    scrollState: ScrollState,
    modifier: Modifier = Modifier
) {
    val text = if (isExpanded) {
        description
    } else {
        val newText = description.substring(0, 250)
        newText.replaceRange(newText.lastIndex - 3, newText.length, "...")
    }

    Text(
        text = text,
        modifier = modifier
            .verticalScroll(scrollState)
            .padding(8.dp)
    )
}