package com.flockinger.treasurehunt.api

import com.flockinger.treasurehunt.api.dto.HuntingResultDto
import com.flockinger.treasurehunt.api.dto.TreasureMapDto
import com.flockinger.treasurehunt.service.TreasureHunter
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class TreasureHuntingController(val hunter: TreasureHunter) {

    @PostMapping("/findtreasure")
    fun findTreasure(@RequestBody treasureMap: TreasureMapDto): HuntingResultDto {
        return hunter.hunt(treasureMap)
    }

}