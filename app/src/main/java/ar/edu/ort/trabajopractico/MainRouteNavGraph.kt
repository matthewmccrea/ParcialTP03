package ar.edu.ort.trabajopractico
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import ar.edu.ort.trabajopractico.screens.*
import ar.edu.ort.trabajopractico.navigation.RootScreen
import ar.edu.ort.trabajopractico.navigation.LeafScreen


@Composable
fun MainRouteNavGraph(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    viewModel: MainActivityViewModel
) {
    NavHost(
        navController = navController,
        startDestination = RootScreen.Home.route,
        modifier = modifier
    ) {
        addHomeRoute(navController, viewModel)
        addProfileRoute(viewModel)
        addSettingsRoute(viewModel)
    }
}

private fun NavGraphBuilder.addHomeRoute(
    navController: NavController,
    viewModel: MainActivityViewModel
) {
    navigation(
        route = RootScreen.Home.route,
        startDestination = LeafScreen.Home.route
    ) {
        composable(LeafScreen.Home.route) {
            viewModel.setTitleBar("Home")
            viewModel.setShowTopBar(true)
            viewModel.setShowBottomBar(true)
            HomeScreen(navController)
        }


    }
}

private fun NavGraphBuilder.addProfileRoute(
    viewModel: MainActivityViewModel
) {
    navigation(
        route = RootScreen.Profile.route,
        startDestination = LeafScreen.Profile.route
    ) {
        composable(LeafScreen.Profile.route) {
            viewModel.setTitleBar("Perfil")
            viewModel.setShowTopBar(true)
            viewModel.setShowBottomBar(true)
            ProfileScreen()
        }
    }
}

private fun NavGraphBuilder.addSettingsRoute(
    viewModel: MainActivityViewModel
) {
    navigation(
        route = RootScreen.Setting.route,
        startDestination = LeafScreen.Setting.route
    ) {
        composable(LeafScreen.Setting.route) {
            viewModel.setTitleBar("Settings")
            viewModel.setShowTopBar(true)
            viewModel.setShowBottomBar(true)
            SettingsScreen()
        }
    }
}

