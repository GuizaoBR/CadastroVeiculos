import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import app.cash.sqldelight.db.SqlDriver
import data.repositories.VeiculoRepository
import moe.tlaster.precompose.PreComposeApp
import moe.tlaster.precompose.navigation.NavHost
import moe.tlaster.precompose.navigation.path
import moe.tlaster.precompose.navigation.rememberNavigator
import moe.tlaster.precompose.navigation.transition.NavTransition
import ui.veiculoFom.VeiculoFormScreen
import ui.veiculoFom.VeiculoFormViewModel
import ui.veiculos.VeiculosListScreen
import ui.veiculos.VeiculosListUiState
import ui.veiculos.VeiculosListViewModel

@Composable
fun App(sqlDriver: SqlDriver) {

    PreComposeApp {
        val veiculoRepository = VeiculoRepository(sqlDriver)
        val navigator = rememberNavigator()
        NavHost(
            navigator = navigator,
            initialRoute = "veiculosList",
            navTransition = NavTransition()
        ){
            scene(
                "veiculosList",
                navTransition = NavTransition()
            ){
                val viewModel = remember {
                    VeiculosListViewModel(veiculoRepository)
                }
                val uiState by viewModel.uiState.collectAsState(VeiculosListUiState())
                VeiculosListScreen(
                    uiState = uiState,
                    onNewVeiculoClick = {
                        navigator.navigate("veiculoForm")
                    },
                    onVeiculoClick = {
                        navigator.navigate("veiculoForm/${it.id}")

                    },
                    onDeleteClick = {
                        veiculoRepository.deleteVeiculo(it)

                    }

                )
            }
            scene(
                "veiculoForm/{id}?",
                navTransition = NavTransition()
            ) {
                val id: Long? = it.path<Long>("id")
                val viewModel = remember {
                    VeiculoFormViewModel(veiculoRepository, id)
                }
                val uiState by viewModel.uiState.collectAsState()
                VeiculoFormScreen(
                    uiState = uiState,
                    onSaveClick = {
                        viewModel.save()
                        navigator.goBack()
                    }
                )
            }
        }
    }
}