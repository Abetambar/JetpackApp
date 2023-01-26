package com.example.jettpacksubmission.ui.sreen.cart

import com.example.jettpacksubmission.model.OrderProduct


data class CartState(
    val orderProduct: List<OrderProduct>,
    val totalPrice: Long
)