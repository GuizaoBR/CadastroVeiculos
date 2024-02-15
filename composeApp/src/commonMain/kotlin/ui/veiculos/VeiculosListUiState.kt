package ui.veiculos

import data.models.Veiculo

data class VeiculosListUiState (
    val veiculos: List<Veiculo> = emptyList()
)