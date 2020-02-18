package com.flockinger.treasurehunt.service

import java.util.*


class TreasureMap(rawTreasureMap: List<List<Int>>) {

    private val treasureMapCells = mutableListOf<TreasureCell>()

    init {
        rawTreasureMap.forEachIndexed { rowIndex, row ->
            row.forEachIndexed { cellIndex, cell ->
                treasureMapCells.add(TreasureCell(cell, rowIndex + 1, cellIndex + 1))
            }
        }
    }


    fun findTreasure(): HuntingResult {
        val visitedCells = mutableListOf<TreasureCell>()
        val firstCell = treasureMapCells.stream()
                .filter { it.row == 1 && it.column == 1 }
                .findFirst()

        firstCell.ifPresent { walkTreasurePath(visitedCells, it) }

        return HuntingResult(visitedCells.toList(),
                visitedCells.stream().anyMatch { it.containsTreasure() }
        )
    }

    private fun walkTreasurePath(visitedCells: MutableList<TreasureCell>, currentCell: TreasureCell) {

        visitedCells.add(currentCell)

        if (!currentCell.containsTreasure() && hasUnvisitedCellsLeft(visitedCells)) {
            findNextCell(currentCell).ifPresent { walkTreasurePath(visitedCells, it) }
        }
    }

    private fun hasUnvisitedCellsLeft(visitedCells: MutableList<TreasureCell>) = visitedCells.count() < treasureMapCells.count()

    private fun findNextCell(currentCell: TreasureCell): Optional<TreasureCell> {
        return treasureMapCells.stream()
                .filter { it.column == currentCell.valueColumn() }
                .filter { it.row == currentCell.valueRow() }
                .findFirst()

    }
}