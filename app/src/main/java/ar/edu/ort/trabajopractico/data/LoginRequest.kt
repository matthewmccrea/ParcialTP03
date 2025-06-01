package ar.edu.ort.trabajopractico.data

data class LoginRequest(
    private val email: String,
    val password: String
)