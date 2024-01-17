package pe.graphica.appdemo.data.network

import pe.graphica.appdemo.data.model.PokemonModel
import retrofit2.Response

interface PokemonApiClient {

    suspend fun getAllPokemon() : Response<List<PokemonModel>>
}