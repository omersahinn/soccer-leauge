package com.soccerleauge.app.network

import com.soccerleauge.app.common.Constants
import com.soccerleauge.app.repository.TeamRepository
import com.soccerleauge.app.repository.TeamRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RetrofitInstance {

    @Provides
    @Singleton
    fun provideTeamApi(): TeamApi {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(TeamApi::class.java)
    }

    @Provides
    @Singleton
    fun provideTeamRepository(api: TeamApi): TeamRepository {
        return TeamRepositoryImpl(api)
    }
}