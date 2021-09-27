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
import kotlinx.coroutines.launch


@ExperimentalPagerApi
@Composable
fun FixtureScreen() {
    val pagerState = rememberPagerState(pageCount = 5)
    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier.background(Color.White)
        ) {
            TabScreen()
        }
    }

}

@ExperimentalPagerApi
@Composable
fun TabScreen() {
    val pagerState = rememberPagerState(pageCount = 3)
    Column(
        modifier = Modifier.background(Color.White)
    ) {
        Tabs(pagerState = pagerState)
        TabsContent(pagerState = pagerState)
    }
}


@ExperimentalPagerApi
@Composable
fun Tabs(pagerState: PagerState) {
    val list = listOf("1. Week", "2. Week", "3. Week", "4. Week", "5. Week")
    val scope = rememberCoroutineScope()

    TabRow(
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
        list.forEachIndexed { index, _ ->
            Tab(
                text = {
                    Text(
                        list[index],
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
fun TabsContent(pagerState: PagerState) {
    HorizontalPager(state = pagerState, dragEnabled = true) {
        Text(text = "asdasdassad")
        Text(text = "asdasdassad")
        Text(text = "asdasdassad")

    }
}
