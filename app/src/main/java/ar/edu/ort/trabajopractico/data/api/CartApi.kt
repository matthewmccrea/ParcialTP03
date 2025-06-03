package ar.edu.ort.trabajopractico.data.api


import retrofit2.Response
import retrofit2.http.GET

interface CartApi {
    @GET("carts/4")
    suspend fun getCart(): Response<CartResponse>
}

