package model

data class Cell(val x: Int, val y: Int, var piece: Piece? = null, var cellType: CellType = CellType.IDLE ) {

}

enum class CellType {
    IDLE,
    FOCUS,
    TD_HOME,
    TD_AWAY
}