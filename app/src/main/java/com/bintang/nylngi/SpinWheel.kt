package com.bintang.nylngi

import android.graphics.Color
import android.media.MediaPlayer
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.bintang.nylngi.luckywheel.LuckyWheel
import com.bintang.nylngi.luckywheel.OnLuckyWheelReachTheTarget
import com.bintang.nylngi.luckywheel.WheelItem
import java.util.Random


class SpinWheel : Fragment() {

    lateinit var Spinwheelp : LuckyWheel
    var item : MutableList<WheelItem> = ArrayList()
    var point = 0
    val nama = arrayOf(
        "nabung 20.000","nabung 30.000","nabung 50.000","ambil 10.000","ambil 20.000","ambil 40.000"
    )
    val warna = arrayOf(
        "#75caee", "#b072d3", "#49935a", "#da615c", "#ecc962" , "#4381e5"
    )



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_spin_wheel, container, false)


        Spinwheelp = view.findViewById(R.id.LW) as LuckyWheel


        setdatagacha()
        setview()


        return view
    }

    private fun setview() {
        Spinwheelp.setLuckyWheelReachTheTarget(object : OnLuckyWheelReachTheTarget{
            override fun onReachTarget() {
                val data: WheelItem = item.get(point-1)
                val namadata = data.text
                Toast.makeText(requireActivity().applicationContext, "yay kamu harus "+ namadata, Toast.LENGTH_SHORT).show()

            }

        })
    }

    private fun setdatagacha() {
        for (i in 0..nama.size - 1){
            item.add(
                WheelItem(Color.parseColor(warna[i]), nama[i])
            )
        }

        Spinwheelp.addWheelItems(item, MediaPlayer.create(requireActivity().applicationContext,R.raw.luckyspin))

        randomdata()

        Spinwheelp.setTarget(point)

    }

    private fun randomdata() {
        val random = Random()
        point = random.nextInt(item.size + 1)
        if (point == 0 || point == item.size + 1){
            point = 1
        }

    }

}