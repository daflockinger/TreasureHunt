package com.flockinger.treasurehunt.service

import com.flockinger.treasurehunt.api.dto.HuntingResultDto
import com.flockinger.treasurehunt.api.dto.TreasureMapDto

interface TreasureHunter {

    fun hunt(treasureMap: TreasureMapDto): HuntingResultDto
}