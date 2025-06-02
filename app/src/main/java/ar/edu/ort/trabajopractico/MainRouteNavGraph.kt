package ar.edu.ort.trabajopractico

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import ar.edu.ort.trabajopractico.components.CartScreen
import ar.edu.ort.trabajopractico.navigation.RootScreen
import ar.edu.ort.trabajopractico.navigation.LeafScreen
import ar.edu.ort.trabajopractico.screens.login.CreateAccountScreen
import ar.edu.ort.trabajopractico.screens.login.ForgotPasswordEmailScreen
import ar.edu.ort.trabajopractico.screens.homepage.BestSellerScreen
import ar.edu.ort.trabajopractico.screens.homepage.HomeScreenScaffold
import ar.edu.ort.trabajopractico.screens.homepage.ProductDetailScreen
import ar.edu.ort.trabajopractico.screens.homepage.SearchScreen
import ar.edu.ort.trabajopractico.screens.login.LoginScreen
import ar.edu.ort.trabajopractico.screens.login.ResetPasswordScreen
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
        addLoginRoute(navController, viewModel)
        addCreateAccountRoute(navController, viewModel)
        addForgotPasswordRoute(navController, viewModel)
        addOnboardingRoute(navController,viewModel)
        addProfileRoute(navController,viewModel)
        addSettingsRoute(navController,viewModel)
        addAccountRoute(viewModel)
        addNotificationRoute(viewModel)
        addPaymentMethodRoute(viewModel)
        addPrivacyRoute(viewModel)
        addSecurityRoute(viewModel)
        addFaqRoute(viewModel)
        addSearchRoute(navController, viewModel)
        addBestSellerRoute(navController,viewModel)
        /*addProductDetailRoute(navController,viewModel)*/
        addCartRoute(navController,viewModel)
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
            HomeScreenScaffold(navController)
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

private fun NavGraphBuilder.addLoginRoute(
    navController: NavHostController,
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
            LoginScreen(navController)
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
            viewModel.setShowBottomBar(true)
            SettingsScreen(navController)
        }
    }
}

private fun NavGraphBuilder.addCreateAccountRoute(
    navController: NavHostController,
    viewModel: MainActivityViewModel
) {
    navigation(
        route = RootScreen.CreateAccount.route,
        startDestination = LeafScreen.CreateAccount.route
    ) {
        composable(LeafScreen.CreateAccount.route) {
            viewModel.setTitleBar("Create Account")
            viewModel.setShowTopBar(true)
            viewModel.setShowBottomBar(true)
            CreateAccountScreen(navController)
        }
    }
}

private fun NavGraphBuilder.addForgotPasswordRoute(
    navController: NavHostController,
    viewModel: MainActivityViewModel
) {
    composable(LeafScreen.ForgotPasswordEmail.route) {
        viewModel.setTitleBar("Forgot Password")
        viewModel.setShowTopBar(false)
        viewModel.setShowBottomBar(false)
        ForgotPasswordEmailScreen(navController)
    }
    composable(LeafScreen.ResetPassword.route) {
        viewModel.setTitleBar("Reset Password")
        viewModel.setShowTopBar(false)
        viewModel.setShowBottomBar(false)
        ResetPasswordScreen(navController)
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
            viewModel.setTitleBar("")
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

private fun NavGraphBuilder.addSecurityRoute(viewModel: MainActivityViewModel) {
    navigation(
        route = RootScreen.Security.route,
        startDestination = LeafScreen.Security.route
    ) {
        composable(LeafScreen.Security.route) {
            viewModel.setTitleBar("Security")
            viewModel.setShowTopBar(true)
            viewModel.setShowBottomBar(false)
            SecurityScreen()
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
            FaqScreen()
        }
    }
}

private fun NavGraphBuilder.addSearchRoute(navController: NavController, viewModel: MainActivityViewModel) {
    navigation(
        route = RootScreen.Search.route,
        startDestination = LeafScreen.Search.route
    ) {
        composable(LeafScreen.Search.route) {
            viewModel.setTitleBar("")
            viewModel.setShowTopBar(true)
            viewModel.setShowBottomBar(false)

            SearchScreen(
                navController,
                searchText = "",
                onSearchTextChange = {},
                selectedCategory = "Food",
                onCategorySelected = {},
                recentSearches = listOf("Royal Canin Persian 500g", "Royal Canin Persian 500g", "Royal Canin Persian 500g")
            )
        }
    }
}

private fun NavGraphBuilder.addBestSellerRoute(
    navController: NavController,
    viewModel: MainActivityViewModel
) {
    navigation(
        route = RootScreen.BestSeller.route,
        startDestination = LeafScreen.BestSeller.route
    ) {
        composable(LeafScreen.BestSeller.route) {
            viewModel.setTitleBar("")
            viewModel.setShowTopBar(true)
            viewModel.setShowBottomBar(false)

            BestSellerScreen(navController)
        }
    }
}
/*private fun NavGraphBuilder.addProductDetailRoute(
    navController: NavController,
    viewModel: MainActivityViewModel
) {
    navigation(
        route = RootScreen.ProductDetail.route,
        startDestination = LeafScreen.ProductDetail.route
    ) {
        composable(LeafScreen.ProductDetail.route) {
            viewModel.setTitleBar("Product Detail")
            viewModel.setShowTopBar(true)
            viewModel.setShowBottomBar(false)
            ProductDetailScreen(navController,)
        }
    }
}*/

private fun NavGraphBuilder.addCartRoute(
    navController: NavController,
    viewModel: MainActivityViewModel
) {
    navigation(
        route = RootScreen.Cart.route,
        startDestination = LeafScreen.Cart.route
    ) {
        composable(LeafScreen.Cart.route) {
            viewModel.setTitleBar("")
            viewModel.setShowTopBar(true)
            viewModel.setShowBottomBar(true)

            CartScreen(
                products = mockProducts,
                onCheckout = {  },
                navController
            )
        }
    }
}
