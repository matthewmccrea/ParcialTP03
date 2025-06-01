package ar.edu.ort.trabajopractico.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class LoginViewModel : ViewModel() {

    // Estado público solo lectura
    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> get() = _isLoading

    // Resultado del login: null = no iniciado, true = éxito, false = error
    private val _loginResult = MutableStateFlow<Boolean?>(null)
    val loginResult: StateFlow<Boolean?> get() = _loginResult

    fun login(email: String, password: String) {
        viewModelScope.launch {
            _isLoading.value = true

            // Simulamos un delay para el login, por ejemplo consulta a un servidor
            delay(2000)

            // Aquí va tu lógica real de autenticación
            val success = (email == "test@example.com" && password == "123456")

            _loginResult.value = success
            _isLoading.value = false
        }
    }
}
