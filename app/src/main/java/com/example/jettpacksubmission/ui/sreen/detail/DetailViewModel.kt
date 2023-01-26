package com.example.jettpacksubmission.ui.sreen.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jettpacksubmission.data.ProductRepository
import com.example.jettpacksubmission.model.OrderProduct
import com.example.jettpacksubmission.model.Product
import com.example.jettpacksubmission.ui.common.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class DetailViewModel(
    private val repository: ProductRepository
) : ViewModel() {

    private val _uiState: MutableStateFlow<UiState<OrderProduct>> =
        MutableStateFlow(UiState.Loading)
    val uiState: StateFlow<UiState<OrderProduct>>
        get() = _uiState

    fun getProductById(productId: Int) {
        viewModelScope.launch {
            _uiState.value = UiState.Loading
            _uiState.value = UiState.Success(repository.getOrderProductById(productId))
        }
    }

    fun addToCart(product: Product, count: Int) {
        viewModelScope.launch {
            repository.updateOrderProduct(product.id, count)
        }
    }
}