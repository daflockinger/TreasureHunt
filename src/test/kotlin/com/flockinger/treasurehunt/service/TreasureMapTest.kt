package com.flockinger.treasurehunt.service

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.tuple
import org.junit.jupiter.api.Test


internal class TreasureMapTest {


    @Test
    fun testFindTreasure_withRandomMapHavingTreasure_shouldFindTreasure() {
        val result = TreasureMap(
                listOf(listOf(34, 21, 32, 41, 25),
                        listOf(14, 42, 43, 14, 31),
                        listOf(54, 45, 52, 42, 23),
                        listOf(33, 15, 51, 31, 35),
                        listOf(21, 52, 33, 13, 23))).findTreasure()

        assertThat(result.foundTreasure).isTrue()
        assertThat(result.visitedCells)
                .hasSize(19)
                .extracting("value", "row", "column")
                .contains(tuple(34, 1, 1), tuple(42, 3, 4), tuple(15, 4, 2), tuple(25, 1, 5),
                        tuple(31, 2, 5), tuple(54, 3, 1), tuple(13, 5, 4), tuple(32, 1, 3),
                        tuple(45, 3, 2), tuple(35, 4, 5), tuple(23, 3, 5), tuple(43, 2, 3),
                        tuple(51, 4, 3), tuple(21, 5, 1), tuple(14, 2, 1), tuple(41, 1, 4),
                        tuple(33, 4, 1), tuple(52, 3, 3), tuple(52, 5, 2))
    }

    @Test
    fun testFindTreasure_withHavingTreasureAfter25Tries_shouldFindTreasure() {
        val result = TreasureMap(
                listOf(listOf(12, 13, 14, 15, 21),
                        listOf(22, 23, 24, 25, 31),
                        listOf(32, 33, 34, 35, 41),
                        listOf(42, 43, 44, 45, 51),
                        listOf(52, 53, 54, 55, 55))).findTreasure()

        assertThat(result.foundTreasure).isTrue()
        assertThat(result.visitedCells)
                .hasSize(25)
                .extracting("value", "row", "column")
                .contains(tuple(55, 5, 5))
    }

    @Test
    fun testFindTreasure_withNoTreasure_shouldScanAllButFindNoTreasure() {
        val result = TreasureMap(
                listOf(listOf(12, 13, 14, 15, 21),
                        listOf(22, 23, 24, 25, 31),
                        listOf(32, 33, 34, 35, 41),
                        listOf(42, 43, 44, 45, 51),
                        listOf(52, 53, 54, 55, 56))).findTreasure()

        assertThat(result.foundTreasure).isFalse()
        assertThat(result.visitedCells)
                .hasSize(25)
    }

    @Test
    fun testFindTreasure_withTreasureButMapHavingALoop_shouldNotFindItButNotLoopIndefinitely() {
        val result = TreasureMap(
                listOf(listOf(12, 13, 11, 14))).findTreasure()

        assertThat(result.foundTreasure).isFalse()
    }

    @Test
    fun testFindTreasure_withEmptyTreasureMap_shouldNotFindTreasure() {
        val result = TreasureMap(
                listOf(listOf())).findTreasure()

        assertThat(result.foundTreasure).isFalse()
        assertThat(result.visitedCells)
                .hasSize(0)
    }

    @Test
    fun testFindTreasure_withInvalidNumber_shouldNotFindItButNotLoopIndefinitely() {
        val result = TreasureMap(
                listOf(listOf(12, 99))).findTreasure()

        assertThat(result.foundTreasure).isFalse()
        assertThat(result.visitedCells)
                .hasSize(2)
    }
}