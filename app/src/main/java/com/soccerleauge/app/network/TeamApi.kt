package com.soccerleauge.app.network

import com.soccerleauge.app.model.Team
import retrofit2.Response
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.Headers

interface TeamApi {
    @Headers("Cache-Control: max-age=640000")
    @GET("/teams")
    suspend fun getTeams(): Response<List<Team>>
}