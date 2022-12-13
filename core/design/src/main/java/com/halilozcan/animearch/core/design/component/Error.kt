package com.halilozcan.animearch.core.design.component

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition
import com.halilozcan.animearch.core.design.R

@Composable
fun Error(@StringRes message: Int, modifier: Modifier = Modifier) {
    Column(modifier = modifier.wrapContentSize(align = Alignment.Center)) {
        val composition by rememberLottieComposition(spec = LottieCompositionSpec.RawRes(R.raw.error))
        LottieAnimation(
            composition = composition,
            iterations = LottieConstants.IterateForever,
            modifier = Modifier
                .align(alignment = Alignment.CenterHorizontally)
                .fillMaxWidth(fraction = 0.8f)
                .height(200.dp)
        )

        Text(
            modifier = Modifier.fillMaxWidth(),
            text = stringResource(message),
            style = MaterialTheme.typography.headlineMedium,
            color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.8f),
            textAlign = TextAlign.Center
        )
    }
}