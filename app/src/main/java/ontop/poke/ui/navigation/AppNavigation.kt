package ontop.poke.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ontop.poke.ui.screen.GeneratePasswordScreen
import ontop.poke.ui.screen.PokemonDetailsScreen
import ontop.poke.ui.screen.PokemonListScreen
import ontop.poke.ui.screen.TransformScreen

@Composable
fun AppNavigation(modifier: Modifier = Modifier) {
    val navController = rememberNavController()

    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = GeneratePassword,
    ) {
        composable<PokemonList> { PokemonListScreen(navController) }
        composable<PokemonDetails> { PokemonDetailsScreen(navController) }
        composable<GeneratePassword> { GeneratePasswordScreen(navController) }
        composable<Transform> { TransformScreen(navController) }
    }
}
