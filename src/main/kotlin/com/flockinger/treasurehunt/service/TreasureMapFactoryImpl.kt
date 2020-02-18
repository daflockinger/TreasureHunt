package com.flockinger.treasurehunt.service;


import com.flockinger.treasurehunt.api.dto.TreasureMapDto
import org.springframework.stereotype.Service
import org.springframework.validation.annotation.Validated

@Service
@Validated
class TreasureMapFactoryImpl : TreasureMapFactory {


    override fun createMap(treasureMap: TreasureMapDto): TreasureMap {
        return TreasureMap(treasureMap.rawMap)
    }


}
