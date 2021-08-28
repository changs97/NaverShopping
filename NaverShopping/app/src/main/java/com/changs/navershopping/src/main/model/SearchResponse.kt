package com.changs.navershopping.src.main.model

import com.google.gson.annotations.SerializedName

data class SearchResponse(
    val display: Int,
    val items: List<Item>,
    val lastBuildDate: String,
    val start: Int,
    val total: Int
)