package com.flockinger.treasurehunt.api.dto

data class HuntingResultDto(val visitedCells: List<TreasureCellDto>, val foundTreasure: Boolean)