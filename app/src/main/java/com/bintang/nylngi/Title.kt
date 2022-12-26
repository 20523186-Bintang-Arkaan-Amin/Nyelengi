package com.bintang.nylngi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper

class Title : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_title2)


        Handler(Looper.getMainLooper()).postDelayed({
                startActivity(Intent(applicationContext, akun_login::class.java))
                finish()
        }, 3000)
    }


}