package ar.edu.ort.trabajopractico.navigation

sealed class RootScreen(val route: String) {
    object Onboarding : RootScreen("onboarding_root")
    object Login : RootScreen("login_root")
    object Home : RootScreen("list_root")
    object Profile : RootScreen("profile_root")
    object Setting : RootScreen("setting_root")
    object Account : RootScreen("account_root")
    object Address : RootScreen("address_root")
    object Notification : RootScreen("notification_root")
    object PaymentMethod : RootScreen("payment_method_root")
    object Privacy : RootScreen("privacy_root")
    object Security : RootScreen("security_root")
    object FAQ : RootScreen("faq_root")
}

sealed class LeafScreen(val route: String) {
    object OnBoarding : LeafScreen("onboarding")
    object Login : LeafScreen("login")
    object Home : LeafScreen("home")
    object Profile : LeafScreen("profile")
    object Setting : LeafScreen("setting")
    object Account : LeafScreen("account")
    object Address : LeafScreen("address")
    object Notification : LeafScreen("notification")
    object PaymentMethod : LeafScreen("payment_method")
    object Privacy : LeafScreen("privacy")
    object Security : LeafScreen("security")
    object FAQ : LeafScreen("faq")
}