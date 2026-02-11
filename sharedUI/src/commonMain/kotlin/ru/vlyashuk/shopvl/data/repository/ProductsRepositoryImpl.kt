package ru.vlyashuk.shopvl.data.repository

import ru.vlyashuk.shopvl.data.datasource.remote.ProductsApiService
import ru.vlyashuk.shopvl.data.mapper.ProductMapper
import ru.vlyashuk.shopvl.domain.DomainError
import ru.vlyashuk.shopvl.domain.model.Product
import ru.vlyashuk.shopvl.domain.repository.ProductsRepository

class ProductsRepositoryImpl(
    private val productsApiService: ProductsApiService
) : ProductsRepository {

    override suspend fun getProducts(): List<Product> {
        return try {
            val response = productsApiService.getProducts().getOrElse { throw DomainError.Network }
            ProductMapper.mapToDomain(response.products)
        } catch (e: DomainError) {
            throw e
        } catch (e: Exception) {
            throw DomainError.Unknown
        }
    }
}