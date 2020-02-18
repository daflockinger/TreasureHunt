package com.flockinger.treasurehunt.service

import com.flockinger.treasurehunt.api.dto.TreasureMapDto

interface TreasureMapFactory {

    fun createMap(treasureMap: TreasureMapDto): TreasureMap
}