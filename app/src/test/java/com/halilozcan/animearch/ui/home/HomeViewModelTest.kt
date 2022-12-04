package com.halilozcan.animearch.ui.home

import com.halilozcan.animearch.R
import com.halilozcan.animearch.data.NetworkResponseState
import com.halilozcan.animearch.domain.usecase.top.FakeGetTopCharacterUseCase
import com.halilozcan.animearch.topAnimeEntities
import com.halilozcan.animearch.topAnimeUiList
import com.halilozcan.animearch.ui.AnimeHomeUiData
import com.halilozcan.animearch.ui.ScreenState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import okio.IOException
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import org.mockito.kotlin.verify
import org.mockito.kotlin.whenever

internal class HomeViewModelTest {

    @Mock
    private lateinit var getFakeGetTopCharacterUseCase: FakeGetTopCharacterUseCase

    private val animeHomeUiMapper = AnimeHomeUiMapper()

    private lateinit var viewModel: HomeViewModel

    @Before
    fun setup() {
        MockitoAnnotations.openMocks(this)
        Dispatchers.setMain(Dispatchers.Unconfined)
        viewModel = HomeViewModel(getFakeGetTopCharacterUseCase, animeHomeUiMapper)
    }

    @Test
    fun state_WhenUseCaseReturnsDownloading_isDownloading() {
        runTest {
            val resultList = listOf(NetworkResponseState.Loading)
            whenever(getFakeGetTopCharacterUseCase.invoke()).thenReturn(resultList.asFlow())

            val listOfEmittedResult =
                mutableListOf<ScreenState<List<AnimeHomeUiData>>>(ScreenState.Loading)
            val job = launch {
                viewModel.screenState.toList(listOfEmittedResult)
            }
            verify(getFakeGetTopCharacterUseCase).invoke()
            assert(listOfEmittedResult.first() is ScreenState.Loading)
            job.cancel()
        }
    }

    @Test
    fun state_WhenUseCaseReturnsDownloadingAndSuccess_isDownloadingAndSuccessSequentially() {
        runTest {
            val resultList = listOf(
                NetworkResponseState.Loading, NetworkResponseState.Success(topAnimeEntities)
            )
            whenever(getFakeGetTopCharacterUseCase.invoke()).thenReturn(resultList.asFlow())

            val listOfEmittedResult =
                mutableListOf(ScreenState.Loading, ScreenState.Success(topAnimeUiList))
            val job = launch {
                viewModel.screenState.toList(listOfEmittedResult)
            }
            verify(getFakeGetTopCharacterUseCase).invoke()
            assert(listOfEmittedResult[1] is ScreenState.Success)
            job.cancel()
        }
    }

    @Test
    fun state_WhenUseCaseReturnsDownloadingAndError_isDownloadingAndErrorSequentially() {
        runTest {
            val resultList = listOf(
                NetworkResponseState.Loading, NetworkResponseState.Error(IOException())
            )
            whenever(getFakeGetTopCharacterUseCase.invoke()).thenReturn(resultList.asFlow())

            val listOfEmittedResult =
                mutableListOf<ScreenState<List<AnimeHomeUiData>>>(
                    ScreenState.Loading,
                    ScreenState.Error(R.string.error)
                )
            val job = launch {
                viewModel.screenState.toList(listOfEmittedResult)
            }
            verify(getFakeGetTopCharacterUseCase).invoke()
            assert(listOfEmittedResult[1] is ScreenState.Error)
            job.cancel()
        }
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }
}