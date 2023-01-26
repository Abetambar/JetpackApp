package com.example.jettpacksubmission.di

import com.example.jettpacksubmission.data.ProductRepository

object Injection {
    fun provideRepository(): ProductRepository {
        return ProductRepository.getInstance()
    }
}