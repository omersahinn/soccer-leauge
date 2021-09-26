package com.soccerleauge.app.repository

import com.soccerleauge.app.model.Team
import com.soccerleauge.app.network.RetrofitInstance
import retrofit2.Response
import retrofit2.http.GET

class TeamRepository {

    suspend fun getTeams(): Response<List<Team>> {
        return RetrofitInstance.api.getTeams()
    }
}