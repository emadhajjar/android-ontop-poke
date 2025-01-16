package ontop.poke.ui.fragment

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import ontop.poke.data.model.Pokemon
import ontop.poke.ui.navigation.PokemonDetails

@Composable
fun PokemonItem(
    pokemon: Pokemon,
    navController: NavController,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .padding(8.dp)
            .fillMaxSize()
            .clickable {
                navController.navigate(PokemonDetails(url = pokemon.url))
            },
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        PokemonImage(pokemon.url)
        Text(
            text = pokemon.name,
            color = Color.Black,
            style = TextStyle(fontWeight = FontWeight.Bold),
            modifier = Modifier.padding(top = 4.dp),
        )
    }
}
