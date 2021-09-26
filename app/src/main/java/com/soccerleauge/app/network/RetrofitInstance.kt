package com.soccerleauge.app.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl("https://614a240c07549f001755a809.mockapi.io/api/v1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val api: TeamApi by lazy {
        retrofit.create(TeamApi::class.java)
    }
}