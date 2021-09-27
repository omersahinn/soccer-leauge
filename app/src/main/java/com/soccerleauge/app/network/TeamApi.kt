package com.soccerleauge.app.network

import com.soccerleauge.app.model.Team
import com.soccerleauge.app.model.TeamDto
import retrofit2.Response
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.Headers

interface TeamApi {
    @GET("teams")
    suspend fun getTeams(): List<TeamDto>
}