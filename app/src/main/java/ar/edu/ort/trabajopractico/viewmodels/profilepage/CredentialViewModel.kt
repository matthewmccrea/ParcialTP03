package ar.edu.ort.trabajopractico.viewmodels.profilepage
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

class CredentialViewModel : ViewModel() {
    var isSubmitted by mutableStateOf(false)
        private set

    fun submit() {
        isSubmitted = true
    }

    fun reset() {
        isSubmitted = false
    }
}
