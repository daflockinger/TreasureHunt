package com.flockinger.treasurehunt.api

import com.flockinger.treasurehunt.api.dto.TreasureMapDto
import com.flockinger.treasurehunt.service.HuntingResult
import com.flockinger.treasurehunt.service.TreasureMapFactory
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class TreasureHuntingController(private val mapFactory: TreasureMapFactory) {

    @PostMapping("/findtreasure")
    fun findTreasure(@RequestBody rawTreasureMap: TreasureMapDto): HuntingResult {
        val treasureMap = mapFactory.createMap(rawTreasureMap)
        return treasureMap.findTreasure()
    }

}