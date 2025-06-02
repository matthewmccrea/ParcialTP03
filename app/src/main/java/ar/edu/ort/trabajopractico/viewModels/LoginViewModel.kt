package ar.edu.ort.trabajopractico.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ar.edu.ort.trabajopractico.data.LoginRequest
import ar.edu.ort.trabajopractico.data.api.RetrofitClient
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

    fun login(username: String, password: String) {
        viewModelScope.launch {
            _isLoading.value = true

            try {
                val response = RetrofitClient.authApi.login(LoginRequest(username, password))

                if (response.isSuccessful) {
                    val user = response.body()
                    _loginResult.value = true
                } else {
                    _loginResult.value = false
                }

            } catch (e: Exception) {
                e.printStackTrace()
                _loginResult.value = false
            } finally {
                _isLoading.value = false
            }
        }
    }

}
