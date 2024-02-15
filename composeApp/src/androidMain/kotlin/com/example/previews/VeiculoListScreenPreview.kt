package com.example.previews

import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import data.models.Veiculo
import ui.veiculos.VeiculosListScreen
import ui.veiculos.VeiculosListUiState

@Preview
@Composable
fun VeiculoListScreenPreview() {
    var veiculos: MutableList<Veiculo> = emptyList<Veiculo>().toMutableList()

    repeat(20) {
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
    Surface {
        VeiculosListScreen(
            uiState = VeiculosListUiState(
                veiculos.toList()
            )
        )
    }
}
