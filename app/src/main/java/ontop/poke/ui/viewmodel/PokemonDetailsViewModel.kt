package ontop.poke.ui.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.toRoute
import kotlinx.coroutines.launch
import ontop.poke.data.repository.PokemonRepository
import ontop.poke.ui.navigation.PokemonDetails
import ontop.poke.ui.viewstate.PokemonDetailsViewState

class PokemonDetailsViewModel(
    savedStateHandle: SavedStateHandle,
) : ViewModel() {
    private val route = savedStateHandle.toRoute<PokemonDetails>()

    private val _repository: PokemonRepository = PokemonRepository()

    private val _viewState = mutableStateOf(PokemonDetailsViewState())
    val viewState: State<PokemonDetailsViewState> = _viewState

    init {
        fetchPokemonDetails()
    }

    private fun fetchPokemonDetails() {
        viewModelScope.launch {
            try {
                val response = _repository.getPokemonDetails(route.url)
                _viewState.value = _viewState.value.copy(
                    isLoading = false,
                    pokemonDetails = response,
                    url = route.url,
                    error = null,
                )
            } catch (e: Exception) {
                _viewState.value = _viewState.value.copy(
                    error = "Error fetching details ${e.message}",
                    isLoading = false,
                )
            }
        }
    }
}
