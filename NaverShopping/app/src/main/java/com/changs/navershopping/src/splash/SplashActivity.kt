package com.changs.navershopping.src.splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.changs.navershopping.config.BaseActivity
import com.changs.navershopping.databinding.ActivityMainBinding.inflate
import com.changs.navershopping.databinding.ActivitySplashBinding
import com.changs.navershopping.src.main.MainActivity


class SplashActivity : BaseActivity<ActivitySplashBinding>(ActivitySplashBinding::inflate) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }, 1500)
    }
}