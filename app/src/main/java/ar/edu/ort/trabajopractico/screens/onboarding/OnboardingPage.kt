package ar.edu.ort.trabajopractico.screens.onboarding

import androidx.annotation.DrawableRes

data class OnboardingPage(
    val title: String,
    val description: String,
    @DrawableRes val imageRes: Int
)
