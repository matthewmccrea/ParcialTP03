package ar.edu.ort.trabajopractico
import androidx.compose.material3.DrawerState
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import ar.edu.ort.trabajopractico.navigation.RootScreen
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class MainNavActions(
    private val navController: NavHostController,
    private val scope: CoroutineScope,
    private val drawerState: DrawerState

) {
    val navigateToHome: () -> Unit = {
        scope.launch {
            drawerState.close()
            navController.navigate(RootScreen.Home.route) {
                popUpTo(navController.graph.findStartDestination().id) {
                    saveState = true
                }
                launchSingleTop = true
                restoreState = true
            }
        }
    }

    val navigateToProfile: () -> Unit = {
        scope.launch {
            drawerState.close()
            navController.navigate(RootScreen.Profile.route) {
                popUpTo(navController.graph.findStartDestination().id) {
                    saveState = true
                }
                launchSingleTop = true
                restoreState = true
            }
        }
    }

    val navigateToSettings: () -> Unit = {
        scope.launch {
            drawerState.close()
            navController.navigate(RootScreen.Setting.route) {
                popUpTo(navController.graph.findStartDestination().id) {
                    saveState = true
                }
                launchSingleTop = true
                restoreState = true
            }
        }
    }

    val navigateToLogin: () -> Unit = {
        scope.launch {
            drawerState.close()
            navController.navigate(RootScreen.Login.route) {
                popUpTo(navController.graph.findStartDestination().id) {
                    saveState = true
                }
                launchSingleTop = true
                restoreState = true
            }
        }
    }

    val navigateToOnboarding: () -> Unit = {
        scope.launch {
            drawerState.close()
            navController.navigate(RootScreen.Onboarding.route) {
                popUpTo(navController.graph.findStartDestination().id) {
                    saveState = true
                }
                launchSingleTop = true
                restoreState = true
            }
        }
    }



}
