package com.halilozcan.animearch.feature.detail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Cyan
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.text.ExperimentalTextApi
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.halilozcan.animearch.core.design.theme.AnimeArchTheme

private val GradientColors = listOf(Cyan, Color.Yellow, Color.Magenta)

@OptIn(ExperimentalTextApi::class)
@Composable
fun NameSection(name: String, kanjiName: String, modifier: Modifier = Modifier) {
    val offset = Offset(2.0f, 2.0f)
    Column(modifier = modifier) {
        Text(
            text = name,
            modifier = Modifier.padding(horizontal = 8.dp),
            fontFamily = FontFamily.Cursive,
            style = MaterialTheme.typography.headlineMedium.copy(
                shadow = Shadow(
                    color = Color.Red,
                    offset = offset,
                    blurRadius = 2f
                )
            )
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = kanjiName,
            modifier = Modifier.padding(horizontal = 8.dp),
            style = MaterialTheme.typography.bodyMedium.copy(
                brush = Brush.linearGradient(colors = GradientColors)
            )
        )
    }
}

@Preview
@Composable
fun NamePreview() {
    AnimeArchTheme {
        NameSection(name = "Hello", kanjiName = "ルルーシュ・ランペルージ")
    }
}