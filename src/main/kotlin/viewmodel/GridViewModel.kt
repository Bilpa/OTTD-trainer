package viewmodel

import androidx.compose.runtime.mutableStateListOf
import model.Cell
import model.CellType

class GridViewModel(
    val width: Int = 15,
    val height: Int = 26
) {

    val grid = mutableStateListOf<Cell>()

    init {
        createGrid()
    }

    private fun createGrid(){
        grid.clear()
        for (y in 0 until height){
            for(x in 0 until width){
                when(y){
                    0 -> grid.add(Cell(x,y, cellType = CellType.TD_AWAY))
                    height-1 -> grid.add(Cell(x,y, cellType = CellType.TD_HOME))
                    else ->  grid.add(Cell(x,y))
                }
            }
        }
    }

    fun onCellClicked(cell: Cell){
        val index = grid.indexOfFirst { it.x == cell.x && it.y == cell.y }

        if (index != -1){
            val newCell = when (cell.cellType){
                CellType.IDLE -> Cell(cell.x,cell.y, cellType = CellType.FOCUS)
                CellType.FOCUS -> Cell(cell.x,cell.y, cellType = CellType.IDLE)
                else -> cell

            }
            grid[index] = newCell
        }




    }
}