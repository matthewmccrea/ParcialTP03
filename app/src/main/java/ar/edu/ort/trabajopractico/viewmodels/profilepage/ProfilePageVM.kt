package ar.edu.ort.trabajopractico.viewmodels.profilepage

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class ProfilePageVM : ViewModel() {

    var isSeller by mutableStateOf(true)
        private set

    var selectedTab by mutableStateOf("Product")
        private set

    fun toggleMode() {
        isSeller = !isSeller
        selectedTab = if (isSeller) "Product" else "Saved"
    }

    fun selectTab(tab: String) {
        selectedTab = tab
    }
}