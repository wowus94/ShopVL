package ru.vlyashuk.shopvl.data.datasource.remote.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ProductDto(
    @SerialName("id")
    val id: Long,

    @SerialName("title")
    val title: String,

    @SerialName("description")
    val description: String,

    @SerialName("price")
    val price: Double,

    @SerialName("discountPercentage")
    val discountPercentage: Double? = null,

    @SerialName("rating")
    val rating: Double? = null,

    @SerialName("stock")
    val stock: Int? = null,

    @SerialName("brand")
    val brand: String? = null,

    @SerialName("category")
    val category: String? = null,

    @SerialName("thumbnail")
    val thumbnail: String,

    @SerialName("images")
    val images: List<String>? = null
)
