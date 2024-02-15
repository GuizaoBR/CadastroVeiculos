package data

import app.cash.sqldelight.db.SqlDriver
import com.example.VeiculosDatabase
import data.mapper.toVeiculo
import data.models.Veiculo

expect class DriverFactory {
    fun createDriver(): SqlDriver
}

fun VeiculosDatabase.setVeiculo(veiculo: Veiculo){
    return veiculosQueries.insertVeiculo(
        veiculo.id,
        veiculo.fabricante,
        veiculo.modelo,
        veiculo.anoFabricacao,
        veiculo.anoModelo,
        veiculo.placa,
        veiculo.apelido
    )
}


fun VeiculosDatabase.getAll(): MutableList<Veiculo> {
    return veiculosQueries.selectAllVeiculos().executeAsList()
        .map {
            it.toVeiculo()
        }.
        toMutableList()
}

fun VeiculosDatabase.updateVeiculo(veiculo: Veiculo) {
    return veiculosQueries.updateVeiculo(
        veiculo.fabricante,
        veiculo.modelo,
        veiculo.anoFabricacao,
        veiculo.anoModelo,
        veiculo.placa,
        veiculo.apelido,
        veiculo.id!!
    )
}

fun VeiculosDatabase.deleteVeiculo(id: Long) = veiculosQueries.deleteVeiculo(id)