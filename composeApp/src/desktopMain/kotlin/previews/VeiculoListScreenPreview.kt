package previews

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.runtime.Composable
import data.models.Veiculo
import ui.veiculos.VeiculosListScreen
import ui.veiculos.VeiculosListUiState

@Preview
@Composable
fun VeiculoListScreenPreview() {
    var veiculos : MutableList<Veiculo> = emptyList<Veiculo>().toMutableList()

    repeat(20){
        veiculos.add(
            Veiculo(
            1,
            "teste",
            "teste",
            2021,
            2023,
            "abc1d23"
        )
        )
    }
    VeiculosListScreen(
        uiState = VeiculosListUiState(
            veiculos.toList()
        )
    )
}