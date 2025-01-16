package ontop.poke.ui.fragment

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import ontop.poke.data.model.Pokemon

@Composable
fun PokemonGrid(
    pokemons: List<Pokemon>,
    search: String,
    navController: NavController,
    modifier: Modifier = Modifier,
) {
    LazyVerticalGrid(
        GridCells.Fixed(2),
        modifier = modifier.fillMaxSize()
    ) {
        items(pokemons.filter { it.name.startsWith(search) }) { pokemon ->
            PokemonItem(
                pokemon = pokemon,
                navController = navController,
            )
        }
    }
}
