package com.changs.navershopping.src.main

import com.changs.navershopping.src.main.model.SearchResponse
import retrofit2.Call
import retrofit2.http.*

interface RetrofitInterface {
    @GET("search/shop.json")
    fun getSearch(@Header("X-Naver-Client-Id") clientId: String,
                  @Header("X-Naver-Client-Secret") clientSecret: String,
                  @Query("query") query: String,
                  @Query("display")display : Int) : Call<SearchResponse>


}
