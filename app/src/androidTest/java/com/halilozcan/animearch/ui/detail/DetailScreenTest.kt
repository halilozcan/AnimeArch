package com.halilozcan.animearch.ui.detail

import androidx.activity.compose.setContent
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import com.halilozcan.animearch.animeDetailUiData
import com.halilozcan.animearch.core.common.ScreenState
import com.halilozcan.animearch.feature.detail.DetailScreen
import com.halilozcan.animearch.ui.MainActivity
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import com.halilozcan.animearch.core.common.R as coreRes

internal class DetailScreenTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    private lateinit var errorMessage: String

    @Before
    fun setup() {
        composeTestRule.activity.apply {
            errorMessage = getString(coreRes.string.error)
        }
    }

    @Test
    fun detailAnimeName_whenAnimeResponseSuccess_isShown() {
        composeTestRule.activity.setContent {
            DetailScreen(
                uiState = ScreenState.Success(
                    animeDetailUiData
                )
            )
        }
        composeTestRule.onNodeWithText(animeDetailUiData.name).assertIsDisplayed()
    }

    @Test
    fun detailAnimeKanjiName_whenAnimeResponseSuccess_isShown() {
        composeTestRule.activity.setContent {
            DetailScreen(
                uiState = ScreenState.Success(
                    animeDetailUiData
                )
            )
        }
        composeTestRule.onNodeWithText(animeDetailUiData.nameKanji).assertIsDisplayed()
    }

    @Test
    fun detailErrorMessage_whenAnimeResponseError_isShown() {
        composeTestRule.activity.setContent {
            DetailScreen(uiState = ScreenState.Error(coreRes.string.error))
        }
        composeTestRule.onNodeWithText(errorMessage).assertIsDisplayed()
    }
}