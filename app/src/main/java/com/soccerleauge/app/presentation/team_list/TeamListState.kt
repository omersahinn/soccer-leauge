package com.soccerleauge.app.presentation.team_list

import com.soccerleauge.app.model.Team

data class TeamListState(
    val isLoading: Boolean = false,
    val teams: List<Team> = emptyList(),
    val error: String = ""
)
