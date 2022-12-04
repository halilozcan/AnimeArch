package com.halilozcan.animearch.ui.home

import androidx.annotation.VisibleForTesting
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.halilozcan.animearch.R
import com.halilozcan.animearch.data.NetworkResponseState
import com.halilozcan.animearch.domain.entity.TopAnimeEntity
import com.halilozcan.animearch.domain.mapper.AnimeListMapper
import com.halilozcan.animearch.domain.usecase.top.GetTopCharacterUseCase
import com.halilozcan.animearch.ui.AnimeHomeUiData
import com.halilozcan.animearch.ui.ScreenState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
data class HomeViewModel @Inject constructor(
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
                        _screenState.emit(ScreenState.Error(R.string.error))
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