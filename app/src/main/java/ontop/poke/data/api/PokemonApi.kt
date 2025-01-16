package ontop.poke.data.api

import ontop.poke.data.model.PokemonDetailsResponse
import ontop.poke.data.model.PokemonResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PokemonApi {
    @GET("pokemon")
    suspend fun getPokemonList(
        @Query("limit") limit: Int,
        @Query("offset") offset: Int,
    ): PokemonResponse

    @GET("pokemon/{id}")
    suspend fun getPokemonDetails(
        @Path("id") name: String,
    ): PokemonDetailsResponse
}
