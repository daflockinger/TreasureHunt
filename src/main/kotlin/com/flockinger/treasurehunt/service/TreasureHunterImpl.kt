package com.flockinger.treasurehunt.service;


import com.flockinger.treasurehunt.api.dto.HuntingResultDto
import com.flockinger.treasurehunt.api.dto.TreasureMapDto
import org.springframework.stereotype.Service
import org.springframework.validation.annotation.Validated

@Service
@Validated
class TreasureHunterImpl : TreasureHunter {


    override fun hunt(treasureMap: TreasureMapDto): HuntingResultDto {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


}
