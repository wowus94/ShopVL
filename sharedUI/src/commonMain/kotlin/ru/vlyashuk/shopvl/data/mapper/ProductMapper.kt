package ru.vlyashuk.shopvl.data.mapper

import ru.vlyashuk.shopvl.data.datasource.remote.dto.ProductDto
import ru.vlyashuk.shopvl.domain.model.Product

object ProductMapper {

    fun mapToDomain(dto: ProductDto): Product {
        return Product(
            id = dto.id,
            title = dto.title,
            description = dto.description,
            price = dto.price,
            thumbnailUrl = dto.thumbnail
        )
    }

    fun mapToDomain(dtos: List<ProductDto>): List<Product> {
        return dtos.map { mapToDomain(it) }
    }
}