package com.bintang.nylngi

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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


class Celengan : Fragment() {

    lateinit var recyclerView: RecyclerView
    lateinit var imageBack: ImageView
    lateinit var imageSetting: ImageView
    lateinit var txttotalCelengan: TextView

    var isiCelengan = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_celengan, container, false)

        recyclerView = view.findViewById(R.id.RVcelengan) as RecyclerView
        txttotalCelengan = view.findViewById(R.id.tvidr) as TextView

        imageBack = view.findViewById(R.id.IVback2) as ImageView

        imageSetting = view.findViewById(R.id.IVsetting) as ImageView


        recyclerView.layoutManager = LinearLayoutManager(requireActivity())
        val data = ArrayList<CelenganModel>()
        data.add(CelenganModel(R.drawable.ic_baseline_keyboard_arrow_right_24_yellow,"CelenganUtama","“ya tabungan utama.”"))
        data.add(CelenganModel(R.drawable.ic_baseline_keyboard_arrow_right_24_yellow,"BabiYmir","“buat ngipen.”"))
        data.add(CelenganModel(R.drawable.ic_baseline_keyboard_arrow_right_24_yellow,"MasaDepan","“liat saja nanti.”"))


        val adapter = CelenganAdapter(data, requireContext())
        recyclerView.adapter = adapter



        imageBack.setOnClickListener{
            loadFragment(HalamanUtama())
        }

        imageSetting.setOnClickListener{
            startActivity(Intent(context, Setting::class.java))
        }


        loadTabungan(1)

        return view
    }

    fun loadFragment(fragment: Fragment){
        val transaction = requireActivity().supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container,fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

    private fun loadTabungan(i: Int) {
        NetworkConfig().getServiceCeleng().totalTabungan(i).enqueue(object : Callback<Tabungan> {
            override fun onResponse(call: Call<Tabungan>, response: Response<Tabungan>) {
                try {
                    if (response!!.body()!!.code == 1){
                        val response : Tabungan = response.body()!!
                        val item: List<TabunganItem> = response.tabungan

                        for (x in item) {
                            if (x.debit.toInt() > 0) {
                                isiCelengan = isiCelengan - x.debit.toInt()

                            } else {
                                isiCelengan = isiCelengan + x.kredit.toInt()
                            }
                        }
                        txttotalCelengan.text = "IDR "+ isiCelengan.toString()
                    }else{
                        Toast.makeText(requireActivity().applicationContext, "Data Kosong", Toast.LENGTH_SHORT).show()
                    }
                }catch (e:Exception){
                    e.printStackTrace()
                }
            }

            override fun onFailure(call: Call<Tabungan>, t: Throwable) {
                Toast.makeText(requireActivity().applicationContext, "No Internet Access", Toast.LENGTH_SHORT).show()
            }

        })

    }
}