package ar.edu.ort.trabajopractico.data.api

import ar.edu.ort.trabajopractico.data.Product
import retrofit2.http.GET
import retrofit2.Response

interface ProductApi {
    @GET("products?limit=6&select=title,price,description")
    suspend fun getProducts(): Response<ProductResponse>
}
