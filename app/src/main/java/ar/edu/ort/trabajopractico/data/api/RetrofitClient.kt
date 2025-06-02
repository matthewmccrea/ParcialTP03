package ar.edu.ort.trabajopractico.data.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    // IMPORTANTE: la base debe ser “https://dummyjson.com/”, porque los endpoints comienzan en /auth/...
    private const val BASE_URL = "https://dummyjson.com/"

    val authApi: AuthApi = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(AuthApi::class.java)
}
