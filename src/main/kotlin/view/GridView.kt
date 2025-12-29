package view

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import viewmodel.GridViewModel

@Composable
@Preview
fun GridView(viewModel: GridViewModel) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        Box(
            modifier = Modifier.padding(50.dp)
        ){
            GridContent(viewModel)
        }
    }
}

@Composable
@Preview
fun GridContent(viewModel: GridViewModel){
    Column {
        viewModel.grid
            .chunked(viewModel.width)
            .forEach { row ->
                Row {
                    row.forEach { cell ->
                        CellView(
                            cell = cell,
                            size = 32.dp,
                            onClick = {
                                viewModel.onCellClicked(cell)
                            }
                        )
                    }
                }
            }
    }
}