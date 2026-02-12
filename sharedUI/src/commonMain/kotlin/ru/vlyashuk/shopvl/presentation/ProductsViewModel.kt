package ru.vlyashuk.shopvl.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import ru.vlyashuk.shopvl.domain.DomainError
import ru.vlyashuk.shopvl.domain.model.Product
import ru.vlyashuk.shopvl.domain.usecase.GetProductsUseCase

class ProductsViewModel(
    private val getProductsUseCase: GetProductsUseCase
) : ViewModel() {

    private val _products = MutableStateFlow<List<Product>>(emptyList())
    val products: StateFlow<List<Product>> = _products.asStateFlow()

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading.asStateFlow()

    private val _error = MutableStateFlow<String?>(null)
    val error: StateFlow<String?> = _error.asStateFlow()

    fun loadProducts() {
        viewModelScope.launch {
            _isLoading.value = true
            _error.value = null

            getProductsUseCase()
                .onSuccess { products ->
                    _products.value = products
                }
                .onFailure { exception ->
                    when (exception) {
                        is DomainError.Network -> {
                            _error.value = "Отсутствует подключение к интернету"
                        }

                        is DomainError.NotFound -> {
                            _error.value = "Товары не найдены"
                        }

                        else -> {
                            _error.value = "Произошла ошибка: ${exception.message}"
                        }
                    }
                }

            _isLoading.value = false
        }
    }

    fun retry() {
        loadProducts()
    }
}