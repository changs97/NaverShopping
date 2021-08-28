package com.changs.navershopping.src.main

import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.changs.navershopping.config.BaseActivity
import com.changs.navershopping.databinding.ActivityMainBinding
import com.changs.navershopping.src.main.model.SearchResponse


class MainActivity : BaseActivity<ActivityMainBinding>(ActivityMainBinding::inflate), ActivityView {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.mainBtnSearch.setOnClickListener {
            val title = binding.mainEdittextSearch.text.toString()
            Service(this).tryGetSearchs(title)
            showLoadingDialog(this)
            binding.mainEdittextSearch.text.clear()
        }



    }


    override fun onGetSearchSuccess(response: SearchResponse) {

        // 리사이클러뷰에 LinearLayoutManager 객체 지정.
        val recyclerView = binding.RecyclerView
        recyclerView.layoutManager = LinearLayoutManager(this)

        // 리사이클러뷰에 Adapter 객체 지정.
        val adapter = RecyclerviewAdapter(this, response.items)
        recyclerView.adapter = adapter

        dismissLoadingDialog()
    }


    override fun onGetSearchFailure(message: String) {
        dismissLoadingDialog()
        Log.d("태그","네트워킹 실패")

    }
}