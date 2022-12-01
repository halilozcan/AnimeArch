package com.halilozcan.animearch.ui.home

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.halilozcan.animearch.ui.AnimeHomeUiData
import com.halilozcan.animearch.ui.ScreenState
import com.halilozcan.animearch.ui.theme.AnimeArchTheme

@Composable
fun HomeScreen(
    onAnimeClicked: (AnimeHomeUiData) -> Unit,
    viewModel: HomeViewModel = hiltViewModel()
) {
    val uiState by viewModel.screenState.collectAsState(initial = ScreenState.Loading)

    Surface(color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.3f)) {
        Box(modifier = Modifier.fillMaxSize()) {
            when (uiState) {
                is ScreenState.Error -> {
                    Error()
                }
                ScreenState.Loading -> {
                    Loading()
                }
                is ScreenState.Success -> {
                    AnimeList(
                        (uiState as ScreenState.Success).uiData,
                        onAnimeClicked = onAnimeClicked
                    )
                }
            }
        }
    }
}

@Composable
fun Error() {

}

@Composable
fun Loading() {
    val placeHolderList = Array(10) {
        0
    }.toMutableList()

    LazyColumn(
        userScrollEnabled = false,
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(placeHolderList) {
            LoadingItem()
        }
    }
}

@Composable
fun LoadingItem() {
    val infiniteTransition = rememberInfiniteTransition()

    val alpha by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 1f,
        animationSpec = infiniteRepeatable(
            animation = keyframes {
                durationMillis = 750
                0.7f at 400
            },
            repeatMode = RepeatMode.Reverse
        )
    )

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(120.dp),
        shape = RoundedCornerShape(8.dp),
    ) {
        Row {
            Box(
                modifier = Modifier
                    .width(120.dp)
                    .height(120.dp)
                    .background(Color.LightGray.copy(alpha = alpha))
                    .align(Alignment.CenterVertically)
            )

            Box(
                modifier = Modifier
                    .padding(8.dp)
                    .weight(1f)
                    .fillMaxHeight()
                    .background(Color.LightGray.copy(alpha = alpha))
            )

            Icon(
                imageVector = Icons.Filled.KeyboardArrowDown,
                contentDescription = null,
                modifier = Modifier
                    .alignByBaseline()
                    .padding(8.dp)
            )

        }
    }


}

@Composable
fun AnimeList(animeList: List<AnimeHomeUiData>, onAnimeClicked: (AnimeHomeUiData) -> Unit) {
    val listState = rememberLazyListState()
    LazyColumn(
        state = listState,
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        items(animeList) { anime ->
            Anime(animeHomeUiData = anime, onAnimeClicked = onAnimeClicked)
        }
    }
}

@Composable
fun Anime(animeHomeUiData: AnimeHomeUiData, onAnimeClicked: (AnimeHomeUiData) -> Unit) {
    var isExpanded by rememberSaveable { mutableStateOf(false) }

    val height by animateDpAsState(
        if (isExpanded) 200.dp else 120.dp,
        animationSpec = tween(durationMillis = 300, easing = LinearEasing)
    )
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(height),
        shape = RoundedCornerShape(8.dp),
    ) {
        Row(modifier = Modifier.clickable {
            onAnimeClicked.invoke(animeHomeUiData)
        }) {
            AsyncImage(
                model = animeHomeUiData.imageUrl,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .width(120.dp)
                    .fillMaxHeight()
            )

            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(8.dp)
            ) {
                Text(
                    text = animeHomeUiData.name,
                    style = MaterialTheme.typography.headlineSmall,
                    textAlign = TextAlign.Start,
                    color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.8f),
                    modifier = Modifier.fillMaxWidth()
                )

                Text(
                    text = animeHomeUiData.description,
                    overflow = TextOverflow.Ellipsis,
                    style = MaterialTheme.typography.bodyMedium,
                    textAlign = TextAlign.Start,
                    color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.8f),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 8.dp)
                )
            }

            Icon(
                imageVector = if (isExpanded) Icons.Filled.KeyboardArrowUp else Icons.Filled.KeyboardArrowDown,
                contentDescription = null,
                modifier = Modifier
                    .alignByBaseline()
                    .clickable {
                        isExpanded = isExpanded.not()
                    }
                    .padding(8.dp)
            )

        }
    }
}

@Preview(name = "Dark", uiMode = UI_MODE_NIGHT_YES)
@Preview(name = "Light", uiMode = UI_MODE_NIGHT_NO)
@Composable
fun AnimePreview() {
    AnimeArchTheme {
        Anime(
            animeHomeUiData = AnimeHomeUiData(
                "1",
                "Lelouch Lamperouge",
                "Lorem ipsum dolor lorem ipsum dolor lorem ipsum dolor",
                "url"
            ),
            onAnimeClicked = {}
        )
    }
}

@Preview
@Composable
fun LoadingItemPreview() {
    AnimeArchTheme {
        LoadingItem()
    }
}
