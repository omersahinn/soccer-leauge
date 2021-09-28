package com.soccerleauge.app.presentation.team_list

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.soccerleauge.app.common.ApiResponse
import com.soccerleauge.app.network.use_case.GetTeamsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class TeamViewModel @Inject constructor(
    private val getTeamsUseCase: GetTeamsUseCase,
) : ViewModel() {

    private val _state = mutableStateOf(TeamListState())
    val isDark = mutableStateOf(false)

    val state: State<TeamListState> = _state

    init {
        getTeams()

    }

    private fun getTeams() {

        getTeamsUseCase().onEach { result ->
            when (result) {
                is ApiResponse.Success -> {
                    _state.value = TeamListState(teams = result.data ?: emptyList())
                }
                is ApiResponse.Error -> {
                    _state.value = TeamListState(
                        error = result.message ?: "An unexpected error occured"
                    )
                }
                is ApiResponse.Loading -> {
                    _state.value = TeamListState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }

    fun toggleMode() {
        isDark.value = !isDark.value
    }
}