package com.soccerleauge.app

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.soccerleauge.app.repository.TeamRepository

class MainViewModelFactory(
    private val repository: TeamRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainViewModel(repository) as T
    }

}