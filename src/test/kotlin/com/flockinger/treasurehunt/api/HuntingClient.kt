package com.flockinger.treasurehunt.api


import com.flockinger.treasurehunt.api.dto.TreasureMapDto
import com.flockinger.treasurehunt.service.HuntingResult
import io.micronaut.http.client.annotation.Client
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody

@Client("/")
interface HuntingClient {

    @PostMapping("/findtreasure")
    fun findTreasure(@RequestBody treasureMap: TreasureMapDto): HuntingResult

}
