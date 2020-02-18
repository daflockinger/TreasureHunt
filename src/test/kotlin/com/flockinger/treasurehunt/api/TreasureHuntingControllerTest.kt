package com.flockinger.treasurehunt.api

import com.flockinger.treasurehunt.api.dto.TreasureMapDto
import com.flockinger.treasurehunt.service.TreasureCell
import com.flockinger.treasurehunt.service.TreasureMap
import com.flockinger.treasurehunt.service.TreasureMapFactory
import io.micronaut.test.annotation.MicronautTest
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.groups.Tuple.tuple
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock
import javax.inject.Inject


@MicronautTest
class TreasureHuntingControllerTest {

    @Inject
    lateinit var huntingClient: HuntingClient

    var mapFactory = mock(TreasureMapFactory::class.java)

    @Test
    fun testGreetingService() {
        val rawTreasureMap = TreasureMapDto(listOf(listOf(12, 13, 13)))
        val treasureMap = TreasureMap(listOf(listOf(12, 13, 13)))
        val cells = listOf(TreasureCell(12, 1, 1),
                TreasureCell(13, 1, 2),
                TreasureCell(13, 1, 3))

        `when`(mapFactory.createMap(any())).thenReturn(treasureMap)

        val clientResponse = huntingClient.findTreasure(rawTreasureMap)

        assertThat(clientResponse).extracting("foundTreasure").isEqualTo(true)
        assertThat(clientResponse.visitedCells).extracting("row", "column", "value")
                .contains(tuple(1, 1, 12), tuple(1, 2, 13), tuple(1, 3, 13))
    }

    private fun <T> any(): T {
        return Mockito.any<T>()
    }
}
