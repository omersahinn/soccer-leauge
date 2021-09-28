package com.soccerleauge.app.presentation.team_list

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.soccerleauge.app.common.Screen
import com.soccerleauge.app.model.Team
import com.soccerleauge.app.presentation.team_list.components.TeamListItem

@Composable
fun TeamListScreen(
    navController: NavController,
    viewModel: TeamViewModel = hiltViewModel()
) {
    val state = viewModel.state.value

    Box(modifier = Modifier.fillMaxSize()) {
        Column() {
            LazyColumn(modifier = Modifier.fillMaxSize(fraction = 0.9f)) {
                items(state.teams) { team ->
                    if (team.id != -1)
                        TeamListItem(
                            team = team,
                        )
                }
            }
            FixtureButton(navController, state.teams, state.isLoading)
        }

        if (state.error.isNotBlank()) {
            Text(
                text = state.error,
                color = MaterialTheme.colors.error,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
                    .align(Alignment.Center)
            )
        }
        if (state.isLoading) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }
    }
}

@Composable
fun FixtureButton(navController: NavController, teams: List<Team>, isDisable: Boolean) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        contentAlignment = Alignment.Center
    ) {
        Button(
            onClick = {
                navController.currentBackStackEntry?.savedStateHandle?.set("teams", teams)

                navController.navigate(Screen.FixtureScreen.route)
            },
            enabled = !isDisable
        )
        { Text("Draw Fixture") }
    }
}