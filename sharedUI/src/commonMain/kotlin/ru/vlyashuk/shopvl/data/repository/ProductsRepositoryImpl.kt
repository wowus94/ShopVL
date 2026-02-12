package ru.vlyashuk.shopvl.data.repository

import io.ktor.client.network.sockets.SocketTimeoutException
import kotlinx.io.IOException
import ru.vlyashuk.shopvl.data.datasource.remote.ProductsApiService
import ru.vlyashuk.shopvl.data.mapper.ProductMapper
import ru.vlyashuk.shopvl.domain.DomainError
import ru.vlyashuk.shopvl.domain.model.Product
import ru.vlyashuk.shopvl.domain.repository.ProductsRepository

class ProductsRepositoryImpl(
    private val productsApiService: ProductsApiService
) : ProductsRepository {

    override suspend fun getProducts(): List<Product> {
        val response = productsApiService.getProducts()
            .getOrElse { exception ->
                when (exception) {
                    is SocketTimeoutException,
                    is IOException -> throw DomainError.Network
                    else -> throw DomainError.Unknown
                }
            }

        return ProductMapper.mapToDomain(response.products)
    }
}