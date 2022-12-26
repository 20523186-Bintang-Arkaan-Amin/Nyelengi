package com.bintang.nylngi

import android.content.Intent
import android.graphics.Color

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.*
import androidx.fragment.app.Fragment
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.google.android.material.bottomnavigation.BottomNavigationView
import org.w3c.dom.Text
import java.lang.Exception

class MainActivity : AppCompatActivity() {

        lateinit var bottomNav : BottomNavigationView
        lateinit var btcelengan: Button
        lateinit var bttambah: Button
        lateinit var btambil: Button
        lateinit var btcapaian: Button





    override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_home)

            loadFragment(HalamanUtama())


            btcelengan = findViewById(R.id.btcelengan) as Button
            btcelengan.setOnClickListener{
                loadFragment(Celengan())
            }

            btambil = findViewById(R.id.btambil) as Button
            btambil.setOnClickListener {
                loadFragment(Ambil())
            }

            bttambah = findViewById(R.id.bttambah) as Button
            bttambah.setOnClickListener {
                loadFragment(Simpan())
            }

            btcapaian = findViewById(R.id.btcapaian) as Button
            btcapaian.setOnClickListener {
                loadFragment(SpinWheel())
            }


        }
        private  fun loadFragment(fragment: Fragment){
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.container,fragment)
            transaction.addToBackStack(null)
            transaction.commit()
        }




}


