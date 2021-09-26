package com.soccerleauge.app

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.soccerleauge.app.model.Team
import com.soccerleauge.app.repository.TeamRepository
import kotlinx.coroutines.launch
import retrofit2.Response
import retrofit2.http.GET

class MainViewModel(private val repository: TeamRepository): ViewModel() {

    val myResponse: MutableLiveData<Response<List<Team>>> = MutableLiveData()

    fun getTeams() {
        viewModelScope.launch {
            val response = repository.getTeams()
            myResponse.value = response
        }
    }
}