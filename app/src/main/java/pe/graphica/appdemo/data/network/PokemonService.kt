package pe.graphica.appdemo.data.network

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import pe.graphica.appdemo.data.model.PokemonModel
import javax.inject.Inject

class PokemonService @Inject constructor(private val api:PokemonApiClient) {
    suspend fun getPokemons(): List<PokemonModel> {
        return withContext(Dispatchers.IO) {
            val response = api.getAllPokemon()
            response.body()?.results ?: emptyList()
        }
    }

}