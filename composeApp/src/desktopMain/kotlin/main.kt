import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.runtime.Composable
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import data.DriverFactory

fun main() = application {
    Window(onCloseRequest = ::exitApplication, title = "KotlinProject") {
        App(
            DriverFactory().createDriver()
        )
    }
}

@Preview
@Composable
fun AppDesktopPreview() {
    App(
        DriverFactory().createDriver()
    )
}