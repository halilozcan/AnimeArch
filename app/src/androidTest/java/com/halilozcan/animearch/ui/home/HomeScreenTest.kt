package com.halilozcan.animearch.ui.home

import androidx.activity.compose.setContent
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import com.halilozcan.animearch.R
import com.halilozcan.animearch.animeUiList
import com.halilozcan.animearch.ui.MainActivity
import com.halilozcan.animearch.ui.ScreenState
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class HomeScreenTest {

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
    fun loadingView_whenAnimeResponseLoading_showLoading() {
        composeTestRule.activity.setContent {
            HomeScreen(uiState = ScreenState.Loading, onAnimeClicked = {})
        }
        composeTestRule.onNodeWithTag(LOADING_ITEM_LAZY_COLUMN_TEST_TAG).assertIsDisplayed()
    }


    @Test
    fun animeName_whenAnimeResponseSuccess_isShown() {
        composeTestRule.activity.setContent {
            HomeScreen(uiState = ScreenState.Success(animeUiList), onAnimeClicked = {})
        }
        composeTestRule.onNodeWithText(animeUiList.first().name).assertIsDisplayed()
    }

    @Test
    fun errorMessage_whenAnimeListSuccess_isShown() {
        composeTestRule.activity.setContent {
            HomeScreen(uiState = ScreenState.Error(R.string.error), onAnimeClicked = {})
        }
        composeTestRule.onNodeWithText(errorMessage).assertIsDisplayed()
    }
}