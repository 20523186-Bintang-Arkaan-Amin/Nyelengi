package com.bintang.nylngi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class tambah_celengan : AppCompatActivity() {

    lateinit var IVkembali: ImageView
    lateinit var IVsimpann: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tambah_celengan)

        IVsimpann = findViewById(R.id.IVsimpan) as ImageView
        IVsimpann.setOnClickListener{
            onBackPressed()
        }

        IVkembali = findViewById(R.id.IVback_yellow_edit) as ImageView
        IVkembali.setOnClickListener{
            onBackPressed()
        }


    }

    override fun onBackPressed() {
        super.onBackPressed()
    }
}