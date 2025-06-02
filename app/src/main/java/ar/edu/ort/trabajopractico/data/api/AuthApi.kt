package ar.edu.ort.trabajopractico.data.api

import ar.edu.ort.trabajopractico.data.LoginRequest
import ar.edu.ort.trabajopractico.data.LoginResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthApi {
    // Ruta: POST https://dummyjson.com/auth/login
    @POST("auth/login")
    suspend fun login(@Body request: LoginRequest): Response<LoginResponse>
}
