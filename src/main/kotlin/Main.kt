import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowPosition
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import view.GridView
import viewmodel.GridViewModel

//@Composable
//@Preview
//fun App() {
//    var text by remember { mutableStateOf("Hello, World!") }
//
//    MaterialTheme {
//        Button(onClick = {
//            text = "Hello, Desktop!"
//        }) {
//            Text(text)
//        }
//    }
//}

fun main() = application {

    val viewModel = remember { GridViewModel() }

    val cellSize = 32
    val padding = 60 * 2

    val windowSize = DpSize(
        width = ((viewModel.width * cellSize + padding)).dp,
        height = ((viewModel.height * cellSize + padding + 40)).dp
    )

    Window(onCloseRequest = ::exitApplication,
        title = "OTTD trainer",
        state = rememberWindowState(
            size = windowSize,
            position = WindowPosition.Aligned(Alignment.Center)
        ),
        resizable = true
    ) {
       GridView(viewModel)
    }
}
