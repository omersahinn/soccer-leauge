package com.soccerleauge.app.model

import com.google.gson.annotations.SerializedName

data class TeamDto(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String
)

fun TeamDto.toTeam(): Team {
    return Team(
        id = id,
        name = name,
    )
}