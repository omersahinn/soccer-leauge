package com.soccerleauge.app.repository

import com.soccerleauge.app.model.Team
import com.soccerleauge.app.model.TeamDto
import com.soccerleauge.app.network.TeamApi
import javax.inject.Inject

class TeamRepositoryImpl @Inject constructor(
    private val api: TeamApi
) : TeamRepository{
    override suspend fun getTeams(): List<TeamDto> {
        return api.getTeams()
    }
}