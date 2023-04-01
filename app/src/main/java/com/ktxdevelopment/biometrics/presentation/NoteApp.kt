package com.ktxdevelopment.biometrics.presentation

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.navigation.*
import androidx.navigation.compose.ComposeNavigator
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.ktxdevelopment.biometrics.presentation.home.HomeScreen

@Composable
fun MainApp() {
    val navController = rememberNavController()

    Surface(color = MaterialTheme.colors.background) {

        NavHost(navController, startDestination = NavDestinations.AUTH) {
            composable(route = NavDestinations.AUTH) { AuthScreen(navController) }
            composable(route = NavDestinations.HOME) { HomeScreen(navController) }
            composable(route = NavDestinations.UPSERT) { navBackStackEntry ->
                val id = navBackStackEntry.arguments?.getInt("id")
                UpsertScreen(navController = navController, id)
            }
        }
    }
}

object NavDestinations {
    const val AUTH = "auth"
    const val HOME = "home"
    const val UPSERT = "upsert"
}




fun NavGraphBuilder.composable(
    route: String,
    arguments: List<NamedNavArgument> = emptyList(),
    deepLinks: List<NavDeepLink> = emptyList(),
    content: @Composable (NavBackStackEntry) -> Unit
) {
    addDestination(
        ComposeNavigator.Destination(provider[ComposeNavigator::class], content).apply {
            this.route = route
            arguments.forEach { (argumentName, argument) ->
                addArgument(argumentName, argument)
            }
            deepLinks.forEach { deepLink ->
                addDeepLink(deepLink)
            }
        }
    )
}