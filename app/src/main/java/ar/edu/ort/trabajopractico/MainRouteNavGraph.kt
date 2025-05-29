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
import ar.edu.ort.trabajopractico.screens.paymentmethodscreen.PaymentMethodScreen
import ar.edu.ort.trabajopractico.screens.profilepage.ProfileScreen
import ar.edu.ort.trabajopractico.screens.profilepage.SettingsScreen
import ar.edu.ort.trabajopractico.screens.profilepage.*



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
        addProfileRoute(navController,viewModel)
        addSettingsRoute(navController,viewModel)
        addAccountRoute(viewModel)
        addNotificationRoute(viewModel)
        addPaymentMethodRoute(viewModel)
        addPrivacyRoute(viewModel)
        addSecurityRoute(navController,viewModel)
        addFaqRoute(viewModel)
        addChangeEmail(viewModel)
        addChangePassword(viewModel)
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
    navController: NavController,
    viewModel: MainActivityViewModel
) {
    navigation(
        route = RootScreen.Profile.route,
        startDestination = LeafScreen.Profile.route
    ) {
        composable(LeafScreen.Profile.route) {
            viewModel.setTitleBar("Profile")
            viewModel.setShowTopBar(false)
            viewModel.setShowBottomBar(false)
            ProfileScreen(navController)
        }
    }
}

private fun NavGraphBuilder.addSettingsRoute(
    navController: NavController,
    viewModel: MainActivityViewModel
) {
    navigation(
        route = RootScreen.Setting.route,
        startDestination = LeafScreen.Setting.route
    ) {
        composable(LeafScreen.Setting.route) {
            viewModel.setTitleBar("Settings")
            viewModel.setShowTopBar(true)
            viewModel.setShowBottomBar(false)
            SettingsScreen(navController)
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

private fun NavGraphBuilder.addAccountRoute(viewModel: MainActivityViewModel) {
    navigation(
        route = RootScreen.Account.route,
        startDestination = LeafScreen.Account.route
    ) {
        composable(LeafScreen.Account.route) {
            viewModel.setTitleBar("Account")
            viewModel.setShowTopBar(true)
            viewModel.setShowBottomBar(false)
            AccountScreen()
        }
    }
}


private fun NavGraphBuilder.addNotificationRoute(viewModel: MainActivityViewModel) {
    navigation(
        route = RootScreen.Notification.route,
        startDestination = LeafScreen.Notification.route
    ) {
        composable(LeafScreen.Notification.route) {
            viewModel.setTitleBar("Notification")
            viewModel.setShowTopBar(true)
            viewModel.setShowBottomBar(false)
            NotificationScreen()
        }
    }
}

private fun NavGraphBuilder.addPaymentMethodRoute(viewModel: MainActivityViewModel) {
    navigation(
        route = RootScreen.PaymentMethod.route,
        startDestination = LeafScreen.PaymentMethod.route
    ) {
        composable(LeafScreen.PaymentMethod.route) {
            viewModel.setTitleBar("Payment Method")
            viewModel.setShowTopBar(true)
            viewModel.setShowBottomBar(false)
            PaymentMethodScreen()
        }
    }
}

private fun NavGraphBuilder.addPrivacyRoute(viewModel: MainActivityViewModel) {
    navigation(
        route = RootScreen.Privacy.route,
        startDestination = LeafScreen.Privacy.route
    ) {
        composable(LeafScreen.Privacy.route) {
            viewModel.setTitleBar("Privacy")
            viewModel.setShowTopBar(true)
            viewModel.setShowBottomBar(false)
            PrivacyScreen()
        }
    }
}

private fun NavGraphBuilder.addSecurityRoute(navController: NavController,viewModel: MainActivityViewModel) {
    navigation(
        route = RootScreen.Security.route,
        startDestination = LeafScreen.Security.route
    ) {
        composable(LeafScreen.Security.route) {
            viewModel.setTitleBar("Security")
            viewModel.setShowTopBar(true)
            viewModel.setShowBottomBar(false)
            SecurityScreen(navController)
        }
    }
}



private fun NavGraphBuilder.addFaqRoute(viewModel: MainActivityViewModel) {
    navigation(
        route = RootScreen.FAQ.route,
        startDestination = LeafScreen.FAQ.route
    ) {
        composable(LeafScreen.FAQ.route) {
            viewModel.setTitleBar("FAQ")
            viewModel.setShowTopBar(true)
            viewModel.setShowBottomBar(false)
            FAQScreen()
        }
    }
}




private fun NavGraphBuilder.addChangePassword(viewModel: MainActivityViewModel) {
    navigation(
        route = RootScreen.ChangePassword.route,
        startDestination = LeafScreen.ChangePassword.route
    ) {
        composable(LeafScreen.ChangePassword.route) {
            viewModel.setTitleBar("Change Password")
            viewModel.setShowTopBar(true)
            viewModel.setShowBottomBar(false)
            ChangeCredentialScreen(
                title = "Change Password",
                fields = listOf("New Password", "Confirm Password"),
                buttonText = "Change Password"
            )
        }
    }
}

private fun NavGraphBuilder.addChangeEmail(viewModel: MainActivityViewModel) {
    navigation(
        route = RootScreen.ChangeEmail.route,
        startDestination = LeafScreen.ChangeEmail.route
    ) {
        composable(LeafScreen.ChangeEmail.route) {
            viewModel.setTitleBar("Change Email")
            viewModel.setShowTopBar(true)
            viewModel.setShowBottomBar(false)
            ChangeCredentialScreen(
                title = "Change Email",
                fields = listOf("New Email"),
                buttonText = "Email"
            )
        }
    }
}


