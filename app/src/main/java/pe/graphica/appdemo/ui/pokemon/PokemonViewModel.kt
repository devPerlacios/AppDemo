package pe.graphica.appdemo.ui.pokemon

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import pe.graphica.appdemo.domain.GetPokemonsUseCase
import pe.graphica.appdemo.domain.model.PokemonItem
import javax.inject.Inject

@HiltViewModel
class PokemonViewModel @Inject constructor(
    private val getPokemonsUseCase: GetPokemonsUseCase
) : ViewModel() {

    val pokemonItem = MutableLiveData<PokemonItem>()
    val isLoading = MutableLiveData<Boolean>()

    fun getPokemons() {
        viewModelScope.launch {
            isLoading.postValue(true)
            val result = getPokemonsUseCase()

            if (!result.isNullOrEmpty()) {
                pokemonItem.postValue(result[0])
                isLoading.postValue(false)
            }
        }
    }
}