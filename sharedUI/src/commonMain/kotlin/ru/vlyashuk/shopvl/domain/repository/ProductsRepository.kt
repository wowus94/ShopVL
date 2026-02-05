package ru.vlyashuk.shopvl.domain.repository

import ru.vlyashuk.shopvl.domain.model.Product

interface ProductsRepository {
    suspend fun getProducts(): List<Product>
}