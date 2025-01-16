package ontop.poke.ui.fragment

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import coil3.compose.rememberAsyncImagePainter

@Composable
fun PokemonImage(url: String) {
    val match = Regex("/pokemon/(\\d+)/").find(url)!!
    val (id) = match.destructured

    Image(
        painter = rememberAsyncImagePainter("https://github.com/PokeAPI/sprites/raw/master/sprites/pokemon/other/official-artwork/shiny/${id}.png"),
        contentDescription = null,
        modifier = Modifier
            .fillMaxSize()
            .aspectRatio(1f)
    )
}
