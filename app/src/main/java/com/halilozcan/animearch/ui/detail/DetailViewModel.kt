package com.halilozcan.animearch.ui.detail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.halilozcan.animearch.data.NetworkResponseState
import com.halilozcan.animearch.domain.entity.SingleAnimeEntity
import com.halilozcan.animearch.domain.mapper.AnimeBaseMapper
import com.halilozcan.animearch.domain.usecase.GetSingleCharacterUseCase
import com.halilozcan.animearch.ui.AnimeDetailUiData
import com.halilozcan.animearch.ui.ScreenState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val getSingleCharacterUseCase: GetSingleCharacterUseCase,
    private val savedStateHandle: SavedStateHandle,
    private val mapper: AnimeBaseMapper<SingleAnimeEntity, AnimeDetailUiData>
) : ViewModel() {

    private val _screenState =
        MutableStateFlow<ScreenState<AnimeDetailUiData>>(value = ScreenState.Loading)
    val screenState: Flow<ScreenState<AnimeDetailUiData>> get() = _screenState

    init {
        getSingleAnimeCharacter()
    }

    private fun getSingleAnimeCharacter() {
        viewModelScope.launch {
            savedStateHandle.get<String>("id")?.let { animeId ->
                getSingleCharacterUseCase(animeId).collect {
                    when (it) {
                        is NetworkResponseState.Error -> {
                            _screenState.emit(ScreenState.Error(it.exception.message.orEmpty()))
                        }
                        is NetworkResponseState.Success -> {
                            _screenState.emit(ScreenState.Success(mapper.map(it.result)))
                        }
                        else -> Unit
                    }
                }
            } ?: kotlin.run {
                _screenState.emit(ScreenState.Error("Unable to get anime details"))
            }
        }
    }
}