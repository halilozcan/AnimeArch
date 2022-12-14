package com.halilozcan.animearch.feature.detail

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun ExpandProgress(
    isExpanded: Boolean,
    progress: Float,
    scrollState: ScrollState,
    modifier: Modifier = Modifier,
    onExpandClicked: () -> Unit,
    onProgressChanged: (Float) -> Unit
) {
    val isContentScrollable by remember {
        derivedStateOf { scrollState.maxValue > 0f }
    }

    Column(modifier = modifier.wrapContentHeight()) {
        Icon(
            imageVector = if (isExpanded) Icons.Filled.KeyboardArrowUp else Icons.Filled.KeyboardArrowDown,
            contentDescription = null,
            modifier = Modifier
                .clickable { onExpandClicked() }
                .align(Alignment.CenterHorizontally)
        )

        if (isExpanded && isContentScrollable) {
            if (scrollState.isScrollInProgress) {
                onProgressChanged(scrollState.value.toFloat() / scrollState.maxValue.toFloat() * 100f)
            }
            VerticalProgress(
                newProgress = progress,
                modifier = Modifier
                    .padding(top = 8.dp, bottom = 16.dp)
                    .align(Alignment.CenterHorizontally)
                    .weight(1f)
            )
        } else {
            onProgressChanged(0f)
        }
    }
}

@Composable
fun VerticalProgress(newProgress: Float, modifier: Modifier = Modifier) {
    val progress = animateFloatAsState(targetValue = newProgress / 100)
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(12.dp))
            .background(Color.LightGray)
            .width(16.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxHeight(progress.value)
                .fillMaxWidth()
                .background(
                    Brush.verticalGradient(
                        listOf(
                            Color(0xffE000FF),
                            Color(0xffE000FF),
                            Color(0xFF7700FF),
                            Color(0xFF7700FF),
                        )
                    )
                )
        )
    }
}