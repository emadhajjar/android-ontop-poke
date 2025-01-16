package ontop.poke.ui.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import ontop.poke.ui.fragment.PokemonDetails
import ontop.poke.ui.viewmodel.PokemonDetailsViewModel

@Composable
fun PokemonDetailsScreen(
    navController: NavController,
    modifier: Modifier = Modifier,
) {
    val viewModel: PokemonDetailsViewModel = viewModel()
    val viewState by viewModel.viewState

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
                    modifier = modifier
                        .fillMaxSize()
                        .padding(16.dp)
                ) {
                    Button(
                        onClick = { navController.navigateUp() }
                    ) {
                        Text("back")
                    }

                    viewState.pokemonDetails?.let {
                        PokemonDetails(
                            url = viewState.url ?: "",
                            pokemonDetails = it,
                        )
                    }
                }

            }
        }
    }

}
