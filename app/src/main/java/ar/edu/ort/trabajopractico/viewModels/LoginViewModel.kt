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

    /**
     * El parámetro “email” aquí es el que el usuario ingresó.
     * Internamente, LoginRequest(email, password) pondrá ese email
     * dentro de la propiedad `username`.
     */
    fun login(email: String, password: String) {
        viewModelScope.launch {
            try {
                val request = LoginRequest(email, password)
                val response = RetrofitClient.authApi.login(request)

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
