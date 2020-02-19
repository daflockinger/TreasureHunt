package com.flockinger.treasurehunt.service

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test


internal class TreasureCellTest {

    @Test
    fun testContainsTreasure_withTreasure_shouldReturnTrue() {
        val cell = TreasureCell(23, 2, 3)
        assertThat(cell.containsTreasure()).isTrue()
    }

    @Test
    fun testContainsTreasure_withoutTreasure_shouldReturnFalse() {
        val cell = TreasureCell(23, 1, 2)
        assertThat(cell.containsTreasure()).isFalse()
    }

    @Test
    fun testGetValueRow_shouldReturnCorrect() {
        val cell = TreasureCell(23, 1, 6)
        assertThat(cell.valueRow()).isEqualTo(2)
    }

    @Test
    fun testGetValueColumn_shouldReturnCorrect() {
        val cell = TreasureCell(23, 1, 6)
        assertThat(cell.valueColumn()).isEqualTo(3)
    }
}