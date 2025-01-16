package ontop.poke.data.repository

import ontop.poke.data.api.PokemonApi
import ontop.poke.data.model.PokemonDetailsResponse
import ontop.poke.data.model.PokemonResponse
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class PokemonRepository {
    private val _retrofit = Retrofit
        .Builder()
        .baseUrl("https://pokeapi.co/api/v2/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val _pokemonService = _retrofit.create(PokemonApi::class.java)

    suspend fun getPokemonList(page: Int, limit: Int): PokemonResponse {
        return _pokemonService.getPokemonList(
            limit,
            (page - 1) * limit
        )
    }

    suspend fun getPokemonDetails(url: String): PokemonDetailsResponse {
        val match = Regex("/pokemon/(\\d+)/").find(url)!!
        val (id) = match.destructured

        return _pokemonService.getPokemonDetails(id)
    }
}
