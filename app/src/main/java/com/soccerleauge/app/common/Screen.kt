package com.soccerleauge.app.common

sealed class Screen(val route: String) {
    object TeamListScreen: Screen("team_list_screen")
    object FixtureScreen: Screen("fixture_screen/{teams}")
}