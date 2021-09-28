package com.soccerleauge.app.util

import com.soccerleauge.app.model.FixtureModel
import com.soccerleauge.app.model.Team
import com.soccerleauge.app.model.TeamMatch
import java.util.*
import kotlin.collections.ArrayList
import kotlin.math.round

class Fixture() {

    fun getFixture(teams: MutableList<Team>): MutableList<FixtureModel> {
        var teamList = teams

        if (teams.size % 2 == 1) {
            teamList.add(Team(name = "bye", id = -1))
        }

        val playerCount = teamList.size
        val rounds = playerCount - 1
        val half = playerCount / 2
        val playerIndexes: List<Int> =
            teamList.mapIndexed { i, b -> if (b != null) i else null }.filterNotNull().toList()
                .slice(1..rounds)

        var tournamentPairings = mutableListOf<FixtureModel>()
        for (round in 1..rounds) {
            var TeamPairings = mutableListOf<TeamMatch>()
            var weeklyPairins = mutableListOf<FixtureModel>()
            val newPlayerIndexes = concatenate(listOf(0), playerIndexes)
            val firstHalf = newPlayerIndexes.slice(0..half - 1)
            val secondHalf = newPlayerIndexes.slice(half..playerCount - 1).reversed()

            for (i in 0..firstHalf.size - 1) {

                if (teamList[firstHalf[i]].id != -1 && teamList[secondHalf[i]].id != -1) {
                    TeamPairings.add(
                        TeamMatch(
                            homeTeam = teamList[firstHalf[i]].name,
                            awayTeam = teamList[secondHalf[i]].name
                        )

                    )
                }
            }

            weeklyPairins.add(FixtureModel(week = round, teamMatch = TeamPairings))

            Collections.rotate(playerIndexes, -1)
            tournamentPairings.addAll(weeklyPairins)
        }

        return concatSecondHalf(tournamentPairings)
    }

    fun <T> concatenate(vararg lists: List<T>): List<T> {
        val result: MutableList<T> = ArrayList()
        for (list in lists) {
            result += list
        }
        return result
    }

    fun concatSecondHalf(fixtureList: MutableList<FixtureModel>): MutableList<FixtureModel> {
        val result: MutableList<FixtureModel> = ArrayList()

        for (i in fixtureList) {
            var temp: FixtureModel
            var teamMatchList: MutableList<TeamMatch> = ArrayList()

            for (j in i.teamMatch) {
                teamMatchList.add(TeamMatch(homeTeam = j.awayTeam, awayTeam = j.homeTeam))
            }

            temp = FixtureModel(week = i.week + fixtureList.size, teamMatch = teamMatchList)
            result += temp
        }

        return concatenate(fixtureList, result) as MutableList<FixtureModel>
    }
}