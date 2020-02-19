package com.flockinger.treasurehunt.service

class TreasureCell(val value: Int, val row: Int, val column: Int) {

    private val positionSplitDivisor = 10

    fun containsTreasure() = valueColumn() == column && valueRow() == row

    fun valueRow() = value.div(positionSplitDivisor)

    fun valueColumn() = value.rem(positionSplitDivisor)
}