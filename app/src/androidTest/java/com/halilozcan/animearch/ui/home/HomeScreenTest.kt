package com.halilozcan.animearch.ui.home

import androidx.activity.compose.setContent
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import com.halilozcan.animearch.animeUiList
import com.halilozcan.animearch.core.common.ScreenState
import com.halilozcan.animearch.feature.home.HomeScreen
import com.halilozcan.animearch.feature.home.HomeScreenNavigator
import com.halilozcan.animearch.feature.home.LOADING_ITEM_LAZY_COLUMN_TEST_TAG
import com.halilozcan.animearch.ui.MainActivity
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import com.halilozcan.animearch.core.common.R as coreRes

class HomeScreenTest {

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
    fun loadingView_whenAnimeResponseLoading_showLoading() {
        composeTestRule.activity.setContent {
            HomeScreen(
                uiState = ScreenState.Loading,
                navigator = object : HomeScreenNavigator {
                    override fun navigateToDetailScreen(id: String) {}
                }
            )
        }
        composeTestRule.onNodeWithTag(LOADING_ITEM_LAZY_COLUMN_TEST_TAG).assertIsDisplayed()
    }


    @Test
    fun animeName_whenAnimeResponseSuccess_isShown() {
        composeTestRule.activity.setContent {
            HomeScreen(
                uiState = ScreenState.Success(
                    animeUiList
                ),
                navigator = object : HomeScreenNavigator {
                    override fun navigateToDetailScreen(id: String) {}
                }
            )
        }
        composeTestRule.onNodeWithText(animeUiList.first().name).assertIsDisplayed()
    }

    @Test
    fun errorMessage_whenAnimeListSuccess_isShown() {
        composeTestRule.activity.setContent {
            HomeScreen(
                uiState = ScreenState.Error(coreRes.string.error),
                navigator = object : HomeScreenNavigator {
                    override fun navigateToDetailScreen(id: String) {}
                }
            )
        }
        composeTestRule.onNodeWithText(errorMessage).assertIsDisplayed()
    }
}