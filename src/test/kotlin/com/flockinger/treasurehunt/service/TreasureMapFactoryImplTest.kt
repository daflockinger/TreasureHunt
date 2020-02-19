package com.flockinger.treasurehunt.service

import com.flockinger.treasurehunt.api.dto.TreasureMapDto
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test


internal class TreasureMapFactoryImplTest {

    private val factory: TreasureMapFactory = TreasureMapFactoryImpl()

    @Test
    fun testHunt_shouldReturnFreshTreasureMap() {

        val freshMap = factory.createMap(TreasureMapDto(listOf(listOf())))
        assertThat(freshMap).isNotNull

        val secondMap = factory.createMap(TreasureMapDto(listOf(listOf())))

        assertThat(freshMap).isNotEqualTo(secondMap)
    }
}