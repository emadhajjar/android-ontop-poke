package ontop.poke.ui.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import ontop.poke.ui.fragment.PokemonGrid
import ontop.poke.ui.fragment.SearchInput
import ontop.poke.ui.fragment.VerticalSpacer
import ontop.poke.ui.viewmodel.PokemonListViewModel

@Composable()
fun PokemonListScreen(
    navController: NavController,
    modifier: Modifier = Modifier,
) {
    val viewModel: PokemonListViewModel = viewModel()
    val viewState by viewModel.viewState

    var search by remember {
        mutableStateOf("")
    }

    Box(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        when {
            viewState.isLoading -> {
                CircularProgressIndicator(Modifier.align(Alignment.Center))
            }

            viewState.error != null -> {
                Text("Sorry something went wrong.")
            }

            else -> {
                Column(
                    modifier = Modifier.fillMaxSize()
                ) {
                    SearchInput(
                        search = search,
                        modifier = Modifier,
                        onValueChange = { search = it },
                    )
                    VerticalSpacer()
                    PokemonGrid(
                        pokemons = viewState.items,
                        search = search,
                        navController = navController,
                    )
                }
            }
        }
    }
}
