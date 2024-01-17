package pe.graphica.appdemo.domain

import pe.graphica.appdemo.data.PokemonRepository
import pe.graphica.appdemo.data.database.entities.toDatabase
import pe.graphica.appdemo.domain.model.PokemonItem
import javax.inject.Inject

class GetPokemonsUseCase @Inject constructor(private val repository: PokemonRepository) {
    suspend operator fun invoke():List<PokemonItem>{
        val pokemons = repository.getAllPokemonsFromApi()

        return if(pokemons.isNotEmpty()){
            repository.clearPokemons()
            repository.insertPokemons(pokemons.map { it.toDatabase() })
            pokemons
        }else{
            repository.getAllPokemonsFromDatabase()
        }
    }
}