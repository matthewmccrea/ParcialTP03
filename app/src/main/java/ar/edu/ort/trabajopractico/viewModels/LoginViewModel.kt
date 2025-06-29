package ar.edu.ort.trabajopractico.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ar.edu.ort.trabajopractico.data.LoginRequest
import ar.edu.ort.trabajopractico.data.api.RetrofitClient
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class LoginViewModel : ViewModel() {

    private val auth: FirebaseAuth = FirebaseAuth.getInstance()

    // Estado público solo lectura
    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> get() = _isLoading

    // Resultado del login: null = no iniciado, true = éxito, false = error
    private val _loginResult = MutableStateFlow<Boolean?>(null)
    val loginResult: StateFlow<Boolean?> get() = _loginResult

    fun login(email: String, password: String) {
        viewModelScope.launch {
            _isLoading.value = true

            auth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener { task ->
                    _isLoading.value = false
                    _loginResult.value = task.isSuccessful
                }
                .addOnFailureListener {
                    _isLoading.value = false
                    _loginResult.value = false
                }
        }


    }
}
