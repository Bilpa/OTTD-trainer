package view

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import model.Cell
import model.CellType


@Composable
fun CellView(cell: Cell, size: Dp, onClick: () -> Unit) {

    val color = when (cell.cellType) {
        CellType.TD_HOME -> Color.Blue
        CellType.TD_AWAY -> Color.Red
        CellType.FOCUS -> Color.Gray
        else -> Color.Green

    }

    Box(Modifier
        .size(size)
        .border(1.dp, Color.Gray)
        .background(color)
        .clickable { onClick() }
    )

}