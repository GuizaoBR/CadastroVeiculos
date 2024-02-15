package data.mapper

import com.example.Veiculos
import data.models.Veiculo

fun Veiculos.toVeiculo(): Veiculo {
    val verifiedApelido = apelido?.let {
        it
    } ?:
    let {
        ""
    }
    return Veiculo(id, fabricante, modelo, anoFabricacao, anoModelo, placa, verifiedApelido
    )
}