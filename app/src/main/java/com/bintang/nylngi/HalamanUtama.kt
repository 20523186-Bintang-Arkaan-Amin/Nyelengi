package com.bintang.nylngi

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry

class HalamanUtama : Fragment() {

    lateinit var barChart: BarChart
    lateinit var barData: BarData
    lateinit var barDataSet: BarDataSet
    lateinit var barEntriesList: ArrayList<BarEntry>
    lateinit var imageSetting: ImageView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_halaman_utama, container, false)


        imageSetting = view.findViewById(R.id.IVsetting) as ImageView
        barChart = view.findViewById((R.id.chart_home))

        getBarChartData()

        barDataSet = BarDataSet(barEntriesList, "Bar Chart Data")

        barData = BarData(barDataSet)
        barChart.data = barData
        barDataSet.valueTextColor = Color.WHITE


        barDataSet.setColor(resources.getColor(R.color.barchart_color))

        barDataSet.valueTextSize = 16f
        barChart.description.isEnabled = false

        imageSetting.setOnClickListener{
            startActivity(Intent(context, Setting::class.java))
        }


            return view
    }

    fun getBarChartData() {
        barEntriesList = ArrayList()

        // on below line we are adding data
        // to our bar entries list
        barEntriesList.add(BarEntry(1f, 1f))
        barEntriesList.add(BarEntry(2f, 2f))
        barEntriesList.add(BarEntry(3f, 3f))
        barEntriesList.add(BarEntry(4f, 4f))
        barEntriesList.add(BarEntry(5f, 5f))
        barEntriesList.add(BarEntry(6f, 5f))
        barEntriesList.add(BarEntry(7f, 7f))
    }


}