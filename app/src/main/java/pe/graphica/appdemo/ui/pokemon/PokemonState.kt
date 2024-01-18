package pe.graphica.appdemo.ui.pokemon

import pe.graphica.appdemo.domain.model.PokemonItem

data class PokemonState(
    val list: List<PokemonItem> = emptyList(),
    val isLoading: Boolean = false,
    // pagination
    val pageNumber: Int = 0,
    val isLastPage: Boolean = false,
    val totalElements: Int = 0,
)
