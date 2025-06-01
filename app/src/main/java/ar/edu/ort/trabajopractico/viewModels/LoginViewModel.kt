package ar.edu.ort.trabajopractico.viewModels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ar.edu.ort.trabajopractico.data.LoginRequest
import ar.edu.ort.trabajopractico.data.LoginResponse
import ar.edu.ort.trabajopractico.data.api.RetrofitClient
import kotlinx.coroutines.launch

// LoginViewModel (ya lo tenés así):

class LoginViewModel : ViewModel() {
    var loginResult by mutableStateOf<LoginResponse?>(null)
        private set

    var errorMessage by mutableStateOf<String?>(null)
        private set

    var snackBarMessage by mutableStateOf<String?>(null)
        private set

    fun clearSnackBarMessage() {
        snackBarMessage = null
    }

    fun login(username: String, password: String) {
        viewModelScope.launch {
            try {
                val response = RetrofitClient.authApi.login(LoginRequest(username, password))
                if (response.isSuccessful) {
                    loginResult = response.body()
                    errorMessage = null
                    snackBarMessage = "Login exitoso. ¡Bienvenido, ${loginResult?.firstName}!"
                } else {
                    loginResult = null
                    errorMessage = "Login failed with code: ${response.code()}"
                    snackBarMessage = errorMessage
                }
            } catch (e: Exception) {
                loginResult = null
                errorMessage = "Login failed: ${e.localizedMessage}"
                snackBarMessage = errorMessage
            }
        }
    }
}
