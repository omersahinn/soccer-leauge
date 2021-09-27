package com.soccerleauge.app

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.*
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material.icons.outlined.ThumbUp
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ComposeCompilerApi
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.soccerleauge.app.common.Screen
import com.soccerleauge.app.presentation.fixture.FixtureScreen
import com.soccerleauge.app.presentation.team_list.TeamListScreen
import com.soccerleauge.app.repository.TeamRepository
import com.soccerleauge.app.ui.theme.SoccerleaugeTheme
import dagger.hilt.android.AndroidEntryPoint

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

                            actions = {
                                IconButton(onClick = { }) {
                                    Icon(Icons.Outlined.ThumbUp,"")
                                }
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
                        composable(
                            route = Screen.TeamListScreen.route
                        ) {
                            TeamListScreen(navController)
                        }
                        composable(
                            route = Screen.FixtureScreen.route
                        ) {
                            FixtureScreen()
                        }
                    }

                }
            }
        }


    }
}
