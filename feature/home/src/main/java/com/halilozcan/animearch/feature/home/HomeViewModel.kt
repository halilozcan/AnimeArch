package com.halilozcan.animearch.feature.home

import androidx.annotation.VisibleForTesting
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.halilozcan.animearch.core.common.AnimeHomeUiData
import com.halilozcan.animearch.core.common.NetworkResponseState
import com.halilozcan.animearch.core.common.ScreenState
import com.halilozcan.animearch.core.domain.entity.TopAnimeEntity
import com.halilozcan.animearch.core.domain.mapper.AnimeListMapper
import com.halilozcan.animearch.core.domain.usecase.top.GetTopCharacterUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject
import com.halilozcan.animearch.core.common.R as coreRes

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getTopCharacterUseCase: GetTopCharacterUseCase,
    private val mapper: AnimeListMapper<TopAnimeEntity, AnimeHomeUiData>
) :
    ViewModel() {

    private val _screenState =
        MutableStateFlow<ScreenState<List<AnimeHomeUiData>>>(value = ScreenState.Loading)
    val screenState: StateFlow<ScreenState<List<AnimeHomeUiData>>> get() = _screenState.asStateFlow()

    init {
        getTopAnimeCards()
    }

    @VisibleForTesting
    fun getTopAnimeCards() {
        viewModelScope.launch {
            getTopCharacterUseCase().collectLatest {
                when (it) {
                    is NetworkResponseState.Error -> {
                        _screenState.emit(ScreenState.Error(coreRes.string.error))
                    }
                    NetworkResponseState.Loading -> {
                        _screenState.emit(ScreenState.Loading)
                    }
                    is NetworkResponseState.Success -> {
                        _screenState.emit(ScreenState.Success(mapper.map(it.result)))
                    }
                }
            }
        }
    }
}