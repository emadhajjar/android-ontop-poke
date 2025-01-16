package ontop.poke.ui.navigation

import kotlinx.serialization.Serializable

@Serializable
object PokemonList

@Serializable
data class PokemonDetails(val url: String)

@Serializable
object GeneratePassword

@Serializable
object Transform
