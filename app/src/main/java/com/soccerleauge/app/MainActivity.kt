package com.soccerleauge.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.pager.ExperimentalPagerApi
import com.soccerleauge.app.common.Screen
import com.soccerleauge.app.model.Team
import com.soccerleauge.app.presentation.fixture.FixtureScreen
import com.soccerleauge.app.presentation.team_list.TeamListScreen
import com.soccerleauge.app.ui.theme.SoccerleaugeTheme
import dagger.hilt.android.AndroidEntryPoint

@ExperimentalPagerApi
@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            SoccerleaugeTheme() {
                Scaffold(
                    topBar = {
                        TopAppBar(
                            title = {
                                Text(text = "Soccer Leauge")
                            },

                            backgroundColor = Color.Blue,
                            contentColor = Color.White,
                            elevation = 12.dp
                        )
                    }
                ) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = Screen.TeamListScreen.route
                    ) {
                        composable(Screen.TeamListScreen.route) {
                            TeamListScreen(navController)
                        }
                        composable(Screen.FixtureScreen.route) {
                            val teams =
                                navController.previousBackStackEntry?.savedStateHandle?.get<MutableList<Team>>(
                                    "teams"
                                )

                            teams?.let {
                                FixtureScreen(teams)
                            }

                        }
                    }

                }
            }
        }


    }
}
