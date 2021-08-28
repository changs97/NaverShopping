package com.changs.navershopping.src.main

import android.util.Log
import com.changs.navershopping.config.ApplicationClass
import com.changs.navershopping.config.ApplicationClass.Companion.clientId
import com.changs.navershopping.config.ApplicationClass.Companion.clientSecret
import com.changs.navershopping.src.main.model.SearchResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Service(val view: ActivityView) {

    fun tryGetSearchs(title : String){
        val RetrofitInterface = ApplicationClass.sRetrofit.create(RetrofitInterface::class.java)
        RetrofitInterface.getSearch(clientId, clientSecret ,title,100).enqueue(object : Callback<SearchResponse>{
            override fun onResponse(call: Call<SearchResponse>, response: Response<SearchResponse>) {
               view.onGetSearchSuccess(response.body() as SearchResponse)

            }

            override fun onFailure(call: Call<SearchResponse>, t: Throwable) {
                view.onGetSearchFailure(t.message ?: "통신 오류")
            }
        })
    }



}
