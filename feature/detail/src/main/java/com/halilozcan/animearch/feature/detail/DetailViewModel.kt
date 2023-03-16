package com.halilozcan.animearch.feature.detail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.halilozcan.animearch.core.common.AnimeDetailUiData
import com.halilozcan.animearch.core.common.NetworkResponseState
import com.halilozcan.animearch.core.common.ScreenState
import com.halilozcan.animearch.core.domain.entity.SingleAnimeEntity
import com.halilozcan.animearch.core.domain.mapper.AnimeBaseMapper
import com.halilozcan.animearch.core.domain.usecase.single.GetSingleCharacterUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
import com.halilozcan.animearch.core.common.R as coreRes

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val getSingleCharacterUseCase: GetSingleCharacterUseCase,
    savedStateHandle: SavedStateHandle,
    private val mapper: AnimeBaseMapper<SingleAnimeEntity, AnimeDetailUiData>
) : ViewModel() {

    private val _screenState =
        MutableStateFlow<ScreenState<AnimeDetailUiData>>(value = ScreenState.Loading)
    val screenState: Flow<ScreenState<AnimeDetailUiData>> get() = _screenState

    private val navArgs: DetailRouteNavArgs = savedStateHandle.navArgs()

    init {
        getSingleAnimeCharacter()
    }

    private fun getSingleAnimeCharacter() {
        viewModelScope.launch {
            getSingleCharacterUseCase(navArgs.id).collect {
                when (it) {
                    is NetworkResponseState.Error -> {
                        _screenState.emit(ScreenState.Error(coreRes.string.error))
                    }
                    is NetworkResponseState.Success -> {
                        _screenState.emit(ScreenState.Success(mapper.map(it.result)))
                    }
                    else -> Unit
                }
            }
        }
    }
}