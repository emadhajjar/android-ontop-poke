package ontop.poke.data.model

data class PokemonResponse(
    val count: Int,
    val next: String? = null,
    val previous: String? = null,
    val results: List<Pokemon>,
)

data class Pokemon(
    val name: String,
    val url: String,
    val id: String? = null,
)
