package ui.veiculos

import data.repositories.VeiculoRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.combine
import moe.tlaster.precompose.viewmodel.ViewModel

class VeiculosListViewModel(private val repository: VeiculoRepository) : ViewModel(){

    private  val _uiState: MutableStateFlow<VeiculosListUiState> = MutableStateFlow(
        VeiculosListUiState()
    )

    val uiState
        get() = _uiState.combine(repository.veiculos){ uiState, veiculos ->
            uiState.copy(veiculos = veiculos)
        }
    init {
        repository.getVeiculos()
    }


}