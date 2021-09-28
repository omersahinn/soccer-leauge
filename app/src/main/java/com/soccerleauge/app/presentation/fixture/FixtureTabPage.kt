package com.soccerleauge.app.presentation.fixture

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.soccerleauge.app.model.FixtureModel
import com.soccerleauge.app.model.Team
import com.soccerleauge.app.presentation.team_list.components.TeamListItem

@Composable
fun FixtureTabPage(
    fixtureModel: FixtureModel,
) {
    LazyColumn(
        Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(fixtureModel.teamMatch) { match ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "${match.homeTeam}",
                    style = MaterialTheme.typography.body1,
                    overflow = TextOverflow.Ellipsis
                )
                Text(text = " <--> ")
                Text(
                    text = "${match.awayTeam}",
                    style = MaterialTheme.typography.body1,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
    }
}