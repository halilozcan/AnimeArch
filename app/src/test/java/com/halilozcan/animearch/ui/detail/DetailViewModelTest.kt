package com.halilozcan.animearch.ui.detail

import androidx.lifecycle.SavedStateHandle
import com.halilozcan.animearch.R
import com.halilozcan.animearch.animeDetailUiData
import com.halilozcan.animearch.data.NetworkResponseState
import com.halilozcan.animearch.domain.usecase.single.FakeGetSingleCharacterUseCase
import com.halilozcan.animearch.singleAnimeEntity
import com.halilozcan.animearch.singleAnimePathId
import com.halilozcan.animearch.ui.AnimeDetailUiData
import com.halilozcan.animearch.ui.Detail
import com.halilozcan.animearch.ui.ScreenState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import org.mockito.kotlin.verify
import org.mockito.kotlin.whenever
import java.io.IOException

internal class DetailViewModelTest {

    @Mock
    private lateinit var getFakeGetSingleCharacterUseCase: FakeGetSingleCharacterUseCase

    private val animateDetailUiMapper = AnimeDetailUiMapper()

    private lateinit var savedStateHandle: SavedStateHandle

    private lateinit var viewModel: DetailViewModel


    @Before
    fun setup() {
        MockitoAnnotations.openMocks(this)
        Dispatchers.setMain(Dispatchers.Unconfined)
        savedStateHandle = SavedStateHandle().apply {
            set(Detail.idArg, singleAnimePathId)
        }
        viewModel = DetailViewModel(
            getFakeGetSingleCharacterUseCase,
            savedStateHandle,
            animateDetailUiMapper
        )
    }

    @Test
    fun state_WhenUseCaseReturnsDownloading_isDownloading() {
        runTest {
            val resultList = listOf(NetworkResponseState.Loading)
            whenever(getFakeGetSingleCharacterUseCase.invoke(singleAnimePathId)).thenReturn(
                resultList.asFlow()
            )

            val listOfEmittedResult =
                mutableListOf<ScreenState<AnimeDetailUiData>>(ScreenState.Loading)
            val job = launch {
                viewModel.screenState.toList(listOfEmittedResult)
            }
            verify(getFakeGetSingleCharacterUseCase).invoke(singleAnimePathId)
            assert(listOfEmittedResult.first() is ScreenState.Loading)
            job.cancel()
        }
    }

    @Test
    fun state_WhenUseCaseReturnsDownloadingAndSuccess_isDownloadingAndSuccessSequentially() {
        runTest {
            val resultList = listOf(
                NetworkResponseState.Loading, NetworkResponseState.Success(singleAnimeEntity)
            )
            whenever(getFakeGetSingleCharacterUseCase.invoke(singleAnimePathId)).thenReturn(
                resultList.asFlow()
            )

            val listOfEmittedResult =
                mutableListOf(ScreenState.Loading, ScreenState.Success(animeDetailUiData))
            val job = launch {
                viewModel.screenState.toList(listOfEmittedResult)
            }
            verify(getFakeGetSingleCharacterUseCase).invoke(singleAnimePathId)
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
            whenever(getFakeGetSingleCharacterUseCase.invoke(singleAnimePathId)).thenReturn(
                resultList.asFlow()
            )

            val listOfEmittedResult =
                mutableListOf<ScreenState<AnimeDetailUiData>>(
                    ScreenState.Loading,
                    ScreenState.Error(R.string.error)
                )
            val job = launch {
                viewModel.screenState.toList(listOfEmittedResult)
            }
            verify(getFakeGetSingleCharacterUseCase).invoke(singleAnimePathId)
            assert(listOfEmittedResult[1] is ScreenState.Error)
            job.cancel()
        }
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }
}