package view

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import model.Cell
import model.CellType
import viewmodel.GridViewModel


@Composable
fun CellView(cell: Cell, size: Dp, viewModel: GridViewModel, onClick: () -> Unit) {

    val color = when (cell.cellType) {
        CellType.TD_HOME -> Color.Blue
        CellType.TD_AWAY -> Color.Red
        CellType.FOCUS -> Color.Gray
        else -> Color.Green

    }

    val separatorColor = Color.White
    val borderColor = Color.LightGray
    val right = if(cell.x in viewModel.thickVerticalLines) 4.dp else 1.dp
    val bottom = if(cell.y in viewModel.thickHorizontalLines) 4.dp else 1.dp
    val left = if(cell.x-1 in viewModel.thickVerticalLines ) 0.dp else 1.dp
    val top = if(cell.y-1 in viewModel.thickHorizontalLines ) 0.dp else 1.dp


    Box(modifier = Modifier
        .size(size)
        .background(color)
        .drawBehind {
            drawLine(borderColor, Offset(0f,0f), Offset(size.toPx(),0f), top.toPx())
            drawLine(borderColor, Offset(0f,0f), Offset(0f,size.toPx()), left.toPx())
            drawLine(
                separatorColor,
                Offset(size.toPx(), 0f),
                Offset(size.toPx(),size.toPx()),
                right.toPx()
            )
            drawLine(
                separatorColor,
                Offset(0f,size.toPx()),
                Offset(size.toPx(),size.toPx()),
                bottom.toPx()
            )
        }
        .clickable { onClick() }
    )
//    Box(Modifier
//        .size(size)
//        .border(1.dp, Color.Gray)
//        .background(color)
//        .clickable { onClick() }
//    )

}