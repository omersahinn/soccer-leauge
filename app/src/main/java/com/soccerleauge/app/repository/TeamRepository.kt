package com.soccerleauge.app.repository

import com.soccerleauge.app.model.TeamDto
import retrofit2.http.GET

interface TeamRepository {

    @GET("teams")
    suspend fun getTeams(): List<TeamDto>
}