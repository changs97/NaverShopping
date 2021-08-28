package com.changs.navershopping.src.main

import com.changs.navershopping.src.main.model.SearchResponse


interface ActivityView {

    fun onGetSearchSuccess(response: SearchResponse)

    fun onGetSearchFailure(message: String)


}