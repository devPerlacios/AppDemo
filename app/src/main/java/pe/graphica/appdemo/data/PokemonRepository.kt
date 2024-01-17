package pe.graphica.appdemo.data

import pe.graphica.appdemo.data.database.dao.PokemonDao
import pe.graphica.appdemo.data.database.entities.PokemonEntity
import pe.graphica.appdemo.data.model.PokemonModel
import pe.graphica.appdemo.data.network.PokemonService
import pe.graphica.appdemo.domain.model.PokemonItem
import pe.graphica.appdemo.domain.model.toDomain
import javax.inject.Inject

class PokemonRepository @Inject constructor(
    private val api: PokemonService,
    private val pokemonDao: PokemonDao
) {

    suspend fun getAllPokemonsFromApi(): List<PokemonItem> {
        val response: List<PokemonModel> = api.getPokemons()
        return response.map { it.toDomain() }
    }

    suspend fun getAllPokemonsFromDatabase():List<PokemonItem>{
        val response: List<PokemonEntity> = pokemonDao.getAllPokemon()
        return response.map { it.toDomain() }
    }

    suspend fun insertPokemons(pokemons:List<PokemonEntity>){
        pokemonDao.insertAll(pokemons)
    }

    suspend fun clearPokemons(){
        pokemonDao.deleteAllPokemon()
    }
}