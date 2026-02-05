package ru.vlyashuk.shopvl.domain.usecase

import ru.vlyashuk.shopvl.domain.DomainError
import ru.vlyashuk.shopvl.domain.model.Product
import ru.vlyashuk.shopvl.domain.repository.ProductsRepository

class GetProductsUseCase(
    private val productsRepository: ProductsRepository
) {

    suspend operator fun invoke(): Result<List<Product>> =
        runCatching { productsRepository.getProducts() }
            .onFailure { throw DomainError.Network }
}