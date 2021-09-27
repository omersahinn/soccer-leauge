package com.soccerleauge.app.network.use_case

import com.soccerleauge.app.common.ApiResponse
import com.soccerleauge.app.model.Team
import com.soccerleauge.app.model.toTeam
import com.soccerleauge.app.repository.TeamRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetTeamsUseCase @Inject constructor(
    private val repository: TeamRepository
) {
    operator fun invoke(): Flow<ApiResponse<List<Team>>> = flow {
        try {
            emit(ApiResponse.Loading<List<Team>>())
            val teams = repository.getTeams().map { it.toTeam() }
            emit(ApiResponse.Success<List<Team>>(teams))
        } catch(e: HttpException) {
            emit(ApiResponse.Error<List<Team>>(e.localizedMessage ?: "An unexpected error occured"))
        } catch(e: IOException) {
            emit(ApiResponse.Error<List<Team>>("Couldn't reach server. Check your internet connection."))
        }
    }
}