package ontop.poke.ui.viewstate

import ontop.poke.data.model.Pokemon

data class PokemonListViewState(
    val error: String? = null,
    val isLoading: Boolean = true,
    val items: List<Pokemon> = emptyList(),
)
