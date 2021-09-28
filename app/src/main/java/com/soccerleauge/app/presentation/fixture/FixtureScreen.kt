package com.soccerleauge.app.presentation.fixture

import android.util.Log
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.material.TabRow
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kotlin.properties.Delegates
import com.google.accompanist.pager.*
import com.soccerleauge.app.model.FixtureModel
import com.soccerleauge.app.model.Team
import com.soccerleauge.app.util.Fixture
import kotlinx.coroutines.launch


@ExperimentalPagerApi
@Composable
fun FixtureScreen(teams: MutableList<Team>) {

    val fixtureInstance = Fixture()

    var fixtureList = fixtureInstance.getFixture(teams)

    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier.background(Color.White)
        ) {
            TabScreen(teams, fixtureList)
        }
    }

}

@ExperimentalPagerApi
@Composable
fun TabScreen(teams: List<Team>, fixtureList: List<FixtureModel>) {
    val pagerState = rememberPagerState(pageCount = fixtureList.size)
    Column(
        modifier = Modifier.background(Color.White)
    ) {
        Tabs(pagerState = pagerState, fixtureList)
        TabsContent(pagerState = pagerState, teams, fixtureList[pagerState.currentPage])
    }
}


@ExperimentalPagerApi
@Composable
fun Tabs(pagerState: PagerState, fixtureList: List<FixtureModel>) {
    val scope = rememberCoroutineScope()

    ScrollableTabRow(
        selectedTabIndex = pagerState.currentPage,
        backgroundColor = Color.Blue,
        contentColor = Color.White,
        divider = {
            TabRowDefaults.Divider(
                thickness = 2.dp,
                color = Color.White
            )
        },
        indicator = { tabPositions ->
            TabRowDefaults.Indicator(
                Modifier.pagerTabIndicatorOffset(pagerState, tabPositions),
                height = 2.dp,
                color = Color.Black
            )
        }
    ) {
        fixtureList.forEachIndexed { index, _ ->
            Tab(
                text = {
                    Text(
                        fixtureList[index].week.toString() + ". Week",
                        color = if (pagerState.currentPage == index) Color.White else Color.LightGray
                    )
                },
                selected = pagerState.currentPage == index,
                onClick = {
                    scope.launch {
                        pagerState.animateScrollToPage(index)
                    }
                }
            )
        }
    }
}

@ExperimentalPagerApi
@Composable
fun TabsContent(pagerState: PagerState, teams: List<Team>, fixtureModel: FixtureModel) {
    HorizontalPager(state = pagerState, dragEnabled = true) {
        FixtureTabPage(fixtureModel = fixtureModel)
    }
}
