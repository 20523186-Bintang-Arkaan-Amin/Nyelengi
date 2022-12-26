package com.bintang.nylngi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class Setting : AppCompatActivity() {

    lateinit var IVkembali: ImageView
    lateinit var TVlogout: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_setting)


        IVkembali = findViewById(R.id.IVbacksetting) as ImageView
        IVkembali.setOnClickListener{
            onBackPressed()
        }

        TVlogout = findViewById(R.id.TVlogout) as TextView
        TVlogout.setOnClickListener{
            startActivity(Intent(applicationContext,MainActivity::class.java))
        }
    }




    override fun onBackPressed() {
        super.onBackPressed()
    }
}