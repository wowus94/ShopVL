package ru.vlyashuk.shopvl.domain.model

data class Product(
    val id: Long,
    val title: String,
    val description: String,
    val price: Double,
    val thumbnailUrl: String
)