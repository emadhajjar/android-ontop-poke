package ontop.poke.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import ontop.poke.ui.fragment.VerticalSpacer
import ontop.poke.ui.navigation.PokemonList
import ontop.poke.ui.viewmodel.TransformViewModel

@Composable
fun TransformScreen(
    navController: NavController,
    modifier: Modifier = Modifier
) {
    val viewModel: TransformViewModel = viewModel()
    val viewState by viewModel.viewState

    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Text(viewState.transformedText)

        VerticalSpacer()

        TextField(
            value = viewState.text,
            onValueChange = { viewModel.changeText(it) }
        )

        VerticalSpacer()

        Button(
            onClick = { navController.navigate(PokemonList) }
        ) {
            Text("Navigate to Pokemon List")
        }
    }
}
