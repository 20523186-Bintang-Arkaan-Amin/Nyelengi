package com.bintang.nylngi

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Capaian : Fragment() {
    lateinit var recyclerView: RecyclerView
    lateinit var imageBack: ImageView
    lateinit var imageSetting: ImageView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_capaian, container, false)
        recyclerView = view.findViewById(R.id.RVcapaian) as RecyclerView
        imageBack = view.findViewById(R.id.IVback) as ImageView
        imageSetting = view.findViewById(R.id.IVsetting) as ImageView

        imageBack.setOnClickListener{
            loadFragment(HalamanUtama())
        }

        imageSetting.setOnClickListener{
            startActivity(Intent(context, Setting::class.java))
        }

        recyclerView.layoutManager = LinearLayoutManager(requireActivity())
        val data = ArrayList<pencapaianModel>()
        data.add(pencapaianModel(R.drawable.ios_share,"Ngepet","“tiba-tiba nabung 10x lipat dari biasanya. Kok bisa?”", false))
        data.add(pencapaianModel(R.drawable.ios_share,"S3 Menabung","“menabung semakin banyak tanpa penurunan selama 3 bulan.”", false))
        data.add(pencapaianModel(R.drawable.ios_share,"Geger Geden","“nabung 1 milyar”", false))
        data.add(pencapaianModel(R.drawable.ios_share,"Acumalaka","“melompat tinggi (100 ribu pertama)”", false))
        data.add(pencapaianModel(R.drawable.ios_share,"icikiwir","“sebulan ga nabung...”", false))
        data.add(pencapaianModel(R.drawable.ios_share,"Roger Sumatra","“duit masuk terus setiap hari”", false))

        val adapter = pencapaianAdapter(data)
        recyclerView.adapter = adapter








        return view
    }

    fun loadFragment(fragment: Fragment){
        val transaction = requireActivity().supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container,fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }



}