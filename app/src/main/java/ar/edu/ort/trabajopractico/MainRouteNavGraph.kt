package ar.edu.ort.trabajopractico
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import ar.edu.ort.trabajopractico.navigation.RootScreen
import ar.edu.ort.trabajopractico.navigation.LeafScreen
import ar.edu.ort.trabajopractico.screens.homepage.HomeScreen
import ar.edu.ort.trabajopractico.screens.login.LoginScreen
import ar.edu.ort.trabajopractico.screens.onboarding.OnboardingScreen
import ar.edu.ort.trabajopractico.screens.profilepage.ProfileScreen
import ar.edu.ort.trabajopractico.screens.profilepage.SettingsScreen


@Composable
fun MainRouteNavGraph(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    viewModel: MainActivityViewModel
) {
    NavHost(
        navController = navController,
        startDestination = RootScreen.Onboarding.route,
        modifier = modifier
    ) {

        addHomeRoute(navController, viewModel)
        addOnboardingRoute(navController,viewModel)
        addLoginRoute(viewModel)
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
private fun NavGraphBuilder.addLoginRoute(
    viewModel: MainActivityViewModel
) {
    navigation(
        route = RootScreen.Login.route,
        startDestination = LeafScreen.Login.route
    ) {
        composable(LeafScreen.Login.route) {
            viewModel.setTitleBar("Login")
            viewModel.setShowTopBar(true)
            viewModel.setShowBottomBar(true)
            LoginScreen()
        }
    }
}

private fun NavGraphBuilder.addOnboardingRoute(
    navController: NavController,
    viewModel: MainActivityViewModel

    ) {
    navigation(
        route = RootScreen.Onboarding.route,
        startDestination = LeafScreen.OnBoarding.route
    ) {
        composable(LeafScreen.OnBoarding.route) {
            viewModel.setTitleBar("Onboarding")
            viewModel.setShowTopBar(false)
            viewModel.setShowBottomBar(false)
            OnboardingScreen(navController)
        }
    }
}

