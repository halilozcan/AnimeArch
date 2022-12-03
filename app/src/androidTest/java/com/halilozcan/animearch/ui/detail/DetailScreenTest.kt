package com.halilozcan.animearch.ui.detail

import androidx.activity.compose.setContent
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import com.halilozcan.animearch.R
import com.halilozcan.animearch.animeDetailUiData
import com.halilozcan.animearch.ui.MainActivity
import com.halilozcan.animearch.ui.ScreenState
import org.junit.Before
import org.junit.Rule
import org.junit.Test

internal class DetailScreenTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    private lateinit var errorMessage: String

    @Before
    fun setup() {
        composeTestRule.activity.apply {
            errorMessage = getString(R.string.error)
        }
    }

    @Test
    fun detailAnimeName_whenAnimeResponseSuccess_isShown() {
        composeTestRule.activity.setContent {
            DetailScreen(uiState = ScreenState.Success(animeDetailUiData))
        }
        composeTestRule.onNodeWithText(animeDetailUiData.name).assertIsDisplayed()
    }

    @Test
    fun detailAnimeKanjiName_whenAnimeResponseSuccess_isShown() {
        composeTestRule.activity.setContent {
            DetailScreen(uiState = ScreenState.Success(animeDetailUiData))
        }
        composeTestRule.onNodeWithText(animeDetailUiData.nameKanji).assertIsDisplayed()
    }

    @Test
    fun detailErrorMessage_whenAnimeResponseError_isShown() {
        composeTestRule.activity.setContent {
            DetailScreen(uiState = ScreenState.Error(R.string.error))
        }
        composeTestRule.onNodeWithText(errorMessage).assertIsDisplayed()
    }
}