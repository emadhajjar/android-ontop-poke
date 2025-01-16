package ontop.poke.ui.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ontop.poke.data.repository.PokemonRepository
import ontop.poke.ui.viewstate.PokemonListViewState

class PokemonListViewModel : ViewModel() {
    private val _repository: PokemonRepository = PokemonRepository()

    private val _viewState = mutableStateOf(PokemonListViewState())
    val viewState: State<PokemonListViewState> = _viewState

    init {
        fetchItems()
    }

    private fun fetchItems() {
        viewModelScope.launch {
            try {
                val response = _repository.getPokemonList(1, 1000)
                _viewState.value = _viewState.value.copy(
                    isLoading = false,
                    items = response.results,
                    error = null,
                )
            } catch (e: Exception) {
                _viewState.value = _viewState.value.copy(
                    error = "Error fetching items ${e.message}",
                    isLoading = false,
                )
            }
        }
    }
}
