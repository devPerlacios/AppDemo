package pe.graphica.appdemo.domain.model

import pe.graphica.appdemo.data.database.entities.PokemonEntity
import pe.graphica.appdemo.data.model.PokemonModel

data class PokemonItem(val name:String, val url:String)

fun PokemonModel.toDomain() = PokemonItem(name, url)
fun PokemonEntity.toDomain() = PokemonItem(name, url)