package ru.vlyashuk.shopvl.data.datasource.remote

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import ru.vlyashuk.shopvl.data.datasource.remote.dto.ProductsResponse

class ProductsApiService(
    private val httpClient: HttpClient
) {

    companion object {
        private const val BASE_URL = "https://dummyjson.com"
    }

    suspend fun getProducts(
        limit: Int = 30,
        skip: Int = 0,
        category: String? = null,
        searchQuery: String? = null
    ): Result<ProductsResponse> {
        return try {
            val response = httpClient.get("$BASE_URL/products") {
                parameter("limit", limit)
                parameter("skip", skip)
                category?.let { parameter("category", it) }
                searchQuery?.let { parameter("q", it) }
            }
            Result.success(response.body<ProductsResponse>())
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}