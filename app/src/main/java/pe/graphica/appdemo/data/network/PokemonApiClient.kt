package pe.graphica.appdemo.data.network

import pe.graphica.appdemo.data.model.PaginationResponse
import pe.graphica.appdemo.data.model.PokemonModel
import retrofit2.Response
import retrofit2.http.GET

interface PokemonApiClient {

    @GET("pokemon")
    suspend fun getAllPokemon() : Response<PaginationResponse<PokemonModel>>
}