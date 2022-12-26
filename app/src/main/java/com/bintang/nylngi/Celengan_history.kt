package com.bintang.nylngi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bintang.nylngi.data.NetworkConfig
import com.bintang.nylngi.data.Tabungan
import com.bintang.nylngi.data.TabunganItem
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Celengan_history : AppCompatActivity() {

    lateinit var IVaturan: ImageView
    lateinit var IVkembali: ImageView
    lateinit var txtTotalCelengan: TextView
    lateinit var txtIsiCelengan: TextView
    lateinit var recyclerview: RecyclerView

    val data = ArrayList<TabunganItem>()
    var totalCelengan = 0
    var isiCelengan = 0



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_celengan_history)
        txtTotalCelengan = findViewById(R.id.txt_total_celengan) as TextView
        txtIsiCelengan = findViewById(R.id.txt_sisa_celengan) as TextView
        recyclerview = findViewById<RecyclerView>(R.id.RVhitory)
        recyclerview.layoutManager = LinearLayoutManager(this)



        IVkembali = findViewById(R.id.IVback_yellow) as ImageView
        IVkembali.setOnClickListener{
            onBackPressed()
        }

        loadTabungan(1)
    }

    private fun loadTabungan(i: Int) {
        NetworkConfig().getServiceCeleng().getTabungan(i,"Celengan Utama").enqueue(object : Callback<Tabungan>{
            override fun onResponse(call: Call<Tabungan>, response: Response<Tabungan>) {
                try {
                    if (response!!.body()!!.code == 1){
                        val response : Tabungan = response.body()!!
                        val item: List<TabunganItem> = response.tabungan
                        data.addAll(item)
                        val adapter = CelenganHistoryAdapter(data)
                        recyclerview.adapter = adapter

                        for (x in data) {
                            if (x.debit.toInt() > 0) {
                                isiCelengan = isiCelengan - x.debit.toInt()

                            } else {
                                isiCelengan = isiCelengan + x.kredit.toInt()
                                totalCelengan = totalCelengan + x.kredit.toInt()
                            }
                        }

                        txtIsiCelengan.text = "IDR " + isiCelengan.toString()
                        txtTotalCelengan.text = "IDR "+ totalCelengan.toString()
                    }else{
                        Toast.makeText(applicationContext, "Data Kosong", Toast.LENGTH_SHORT).show()
                    }
                }catch (e:Exception){
                    e.printStackTrace()
                }
            }

            override fun onFailure(call: Call<Tabungan>, t: Throwable) {
                Toast.makeText(applicationContext, "No Internet Access", Toast.LENGTH_SHORT).show()
            }

        })
    }

    override fun onBackPressed() {
        super.onBackPressed()
    }
}