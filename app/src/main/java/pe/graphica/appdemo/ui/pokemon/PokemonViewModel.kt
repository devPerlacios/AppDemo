package pe.graphica.appdemo.ui.pokemon

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import pe.graphica.appdemo.domain.GetPokemonsUseCase
import javax.inject.Inject

@HiltViewModel
class PokemonViewModel @Inject constructor(
    private val getPokemonsUseCase: GetPokemonsUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(PokemonState())
    val uiState = _uiState.asStateFlow()

//    private val _events = MutableSharedFlow<ProductosCuotaVisitadorScreenEvents>()
//    val events = _events.asSharedFlow()

    fun getPokemons() {
        viewModelScope.launch {
            _uiState.update{ it.copy(isLoading = true) }
            val result = getPokemonsUseCase()

            if (!result.isNullOrEmpty()) {
                _uiState.update{ it.copy(isLoading = false, list = result) }
            }
        }
    }
}