package com.changs.navershopping.src.main.model

data class ProductInfo(
    val category: String,
    val company: String,
    val numOfReview: Int,
    val price: Int,
    val reviewRating: Double,
    val salePercent: String,
    val title: String
)