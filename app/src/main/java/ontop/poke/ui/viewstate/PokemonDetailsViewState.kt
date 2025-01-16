package ontop.poke.ui.viewstate

import ontop.poke.data.model.PokemonDetailsResponse

data class PokemonDetailsViewState(
    val error: String? = null,
    val isLoading: Boolean = true,
    val pokemonDetails: PokemonDetailsResponse? = null,
    val url: String? = null
)
