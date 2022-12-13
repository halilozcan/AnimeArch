package com.halilozcan.animearch.feature.detail

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.halilozcan.animearch.core.common.AnimeDetailUiData
import com.halilozcan.animearch.core.common.ScreenState
import com.halilozcan.animearch.core.design.component.Error
import com.halilozcan.animearch.core.design.theme.AnimeArchTheme

@Composable
fun DetailRoute(viewModel: DetailViewModel = hiltViewModel()) {
    val uiState by viewModel.screenState.collectAsState(initial = ScreenState.Loading)
    DetailScreen(uiState = uiState)
}

@Composable
fun DetailScreen(uiState: ScreenState<AnimeDetailUiData>) {
    Surface(color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.3f)) {
        Box(modifier = Modifier.fillMaxSize()) {
            when (uiState) {
                is ScreenState.Error -> {
                    Error(message = uiState.message)
                }
                ScreenState.Loading -> Unit
                is ScreenState.Success -> {
                    SuccessScreen(uiData = uiState.uiData, modifier = Modifier.padding(16.dp))
                }
            }
        }
    }
}

private const val CARD_CONTENT_ALPHA = 0.6f
private val cardContentColor = Color.White.copy(CARD_CONTENT_ALPHA)
private val cardShape = RoundedCornerShape(16.dp, 16.dp, 16.dp, 0.dp)

@Composable
fun SuccessScreen(uiData: AnimeDetailUiData, modifier: Modifier = Modifier) {
    var isExpanded by remember { mutableStateOf(false) }

    var progress by remember { mutableStateOf(0f) }

    val scrollState = rememberScrollState()

    Column(modifier = modifier) {
        Row(modifier = Modifier.align(Alignment.CenterHorizontally)) {
            CircleImage(
                imageUrl = uiData.imageUrl,
                modifier = Modifier.align(Alignment.CenterVertically)
            )

            NameSection(
                name = uiData.name,
                kanjiName = uiData.nameKanji,
                modifier = Modifier.align(Alignment.CenterVertically)
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Row(modifier = Modifier.animateContentSize()) {
            Box(
                modifier = Modifier
                    .background(
                        shape = TriangleEdgeShape(16.dp, LocalDensity.current),
                        color = cardContentColor
                    )
                    .width(16.dp)
                    .padding(start = 16.dp)
                    .align(Alignment.Bottom)
            )

            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = cardShape,
                colors = CardDefaults.cardColors(containerColor = cardContentColor)
            ) {
                Row {
                    Description(
                        description = uiData.description,
                        isExpanded = isExpanded,
                        scrollState = scrollState,
                        modifier = Modifier.weight(1f)
                    )
                    ExpandProgress(
                        isExpanded = isExpanded,
                        progress = progress,
                        scrollState = scrollState,
                        modifier = Modifier.padding(end = 16.dp, start = 8.dp, top = 16.dp),
                        onExpandClicked = { isExpanded = isExpanded.not() },
                        onProgressChanged = {
                            progress = it
                        }
                    )
                }
            }
        }
    }
}

class TriangleEdgeShape(private val offset: Dp, private val localDensity: Density) : Shape {
    override fun createOutline(
        size: Size,
        layoutDirection: LayoutDirection,
        density: Density
    ): Outline {
        val offsetInPx = localDensity.run { offset.toPx() }
        val trianglePath = Path().apply {
            moveTo(0f, 0f)
            lineTo(0f + offsetInPx, 0 - offsetInPx)
            lineTo(0f + offsetInPx, 0f)
        }
        return Outline.Generic(path = trianglePath)
    }
}

@Preview
@Composable
fun DetailScreenPreview() {
    AnimeArchTheme {
        Surface {
            DetailScreen(uiState = ScreenState.Success(animeDetailUiData))
        }
    }
}

private const val description =
    "Age: 17 (first season), 18 (second season)\nDate of Birth:  December 5, 1999 a.t.b. (Sagittarius)\nBlood Type: A\nNationality: Britannian\nHeight: 178 cm (5'10\")\nWeight: 56 kg (123 lbs)\nOccupation: Student, Terrorist, Knightmare Pilot, Politician, Emperor, Prince\nAllegiance: Order of the Black Knights\nPosition: Leader of the Black Knights\nKnightmare: Sutherland, Burai, Gawain, Shinkirou\n\nLelouch vi Britannia (\u30eb\u30eb\u30fc\u30b7\u30e5\u30fb\u30f4\u30a3\u30fb\u30d6\u30ea\u30bf\u30cb\u30a2, Rur\u016bshu Vui Buritania) is the main protagonist of the anime manga series Code Geass. He is the Eleventh Prince of the Holy Britannian Empire and the son of the 98th Emperor of Britannia, Charles zi Britannia.\n\nLelouch is a very clever individual who is also calm, sophisticated, and arrogant due to his aristocratic upbringing. While at school, Lelouch conducts himself as a friendly, likable, and often an easygoing student. However, this is a mask to hide his true nature. While as Zero, his true nature is expressed. His charisma and beliefs in justice gain him the trust and respect of many soldiers and leaders.\n\nHe is known for having a very stoic personality. He never cared about schoolwork, seeing the entire thing as trivial, even though his high intelligence would make it easy for him. He enjoys seeking out challenges, often playing chess against the nobility. In general, Lelouch takes most day-to-day affairs with open disinterest, often not even noticing the affection of others, especially Shirley, his classmate. He has a strong dislike for nobles, viewing them as tepid and \"overprivileged parasites.\"\n\nMany characters have noted that Lelouch is entirely selfish, as his desire to remake the world into what he wants it to become from his desire to avenge his mother's apparent death and Nunnally's sake. However, in time, he realizes that this goal is not just for them but also the entire world.\n\nDespite his cold, calculating demeanor and ruthlessness in battle, he can be a rather compassionate person to his friends and loved ones. To Nunnally, he is a loving older brother, and to Suzaku, a loyal friend, although the two are enemies. Lelouch, at first glance, seems to have relatively little concern for the well-being of his subordinates, but in reality, he does care about them, seeing them as valuable allies.\n\n\nCharacter Background (as Lelouch):\n\nCharacter Background (as Zero):\n\nFirst Season:\n\nSecond Season:\n\n\nGeass:\nLelouch's Geass, bestowed upon him by C.C., gives him \"The Power of Absolute Obedience,\" allowing him to plant commands within a person's mind upon eye contact in a manner comparable to hypnosis. Activation of his Geass is visually represented by the manifestation of a Geass Sigil in his left eye. Commands dictated are written into the minds of the designated targets, the Sigil projecting him from his eye to theirs.\n\nOf all the Geass abilities in the series, Lelouch's has been explored the most and also seems to have the most restrictions, and side effects of any Geass introduced:(Source: Code Geass Wiki, Villains Wiki, Heroes Wiki, Anime and Manga Universe Wiki)"

private val animeDetailUiData = AnimeDetailUiData(
    name = "Lelouch Lamperouge",
    nameKanji = "ルルーシュ・ランペルージ",
    description = description,
    imageUrl = "https://cdn.myanimelist.net/images/characters/8/406163.webp",
    favorites = 159789
)