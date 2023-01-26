package com.example.jettpacksubmission

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.jettpacksubmission.data.ProductRepository
import com.example.jettpacksubmission.ui.sreen.cart.CartViewModel
import com.example.jettpacksubmission.ui.sreen.detail.DetailViewModel
import com.example.jettpacksubmission.ui.sreen.product.ProductViewModel


class ViewModelFactory(private val repository: ProductRepository) :
    ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ProductViewModel::class.java)) {
            return ProductViewModel(repository) as T
        } else if (modelClass.isAssignableFrom(CartViewModel::class.java)) {
            return CartViewModel(repository) as T
        } else if (modelClass.isAssignableFrom(DetailViewModel::class.java)) {
            return DetailViewModel(repository) as T
        }
        throw java.lang.IllegalArgumentException("Unknown ViewModel class: " + modelClass.name)
    }
}