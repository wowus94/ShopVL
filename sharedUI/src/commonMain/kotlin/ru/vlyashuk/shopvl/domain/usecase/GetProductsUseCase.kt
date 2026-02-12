package ru.vlyashuk.shopvl.domain.usecase

import ru.vlyashuk.shopvl.NetworkConnectivityManager
import ru.vlyashuk.shopvl.domain.DomainError
import ru.vlyashuk.shopvl.domain.model.Product
import ru.vlyashuk.shopvl.domain.repository.ProductsRepository

class GetProductsUseCase(
    private val productsRepository: ProductsRepository,
    private val networkConnectivityManager: NetworkConnectivityManager
) {
    suspend operator fun invoke(): Result<List<Product>> {

        if (!networkConnectivityManager.isConnected()) {
            return Result.failure(DomainError.Network)
        }

        return runCatching {
            productsRepository.getProducts()
        }
    }
}