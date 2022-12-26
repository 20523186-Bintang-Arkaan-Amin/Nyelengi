package com.bintang.nylngi

import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.bintang.nylngi.data.NetworkConfig
import com.bintang.nylngi.data.Tabungan
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*


class Simpan : Fragment() {

    lateinit var imageBack: ImageView
    lateinit var teksCalendar : TextView
    val MONTH = arrayOf("Januari", "Februari","maret","april","mei","juni","juli","agustus","september","oktober","november","desember")
    lateinit var tvSimpan : TextView
    lateinit var etdebit : EditText
    lateinit var etCatatan: EditText
    lateinit var spinnerCeleng : Spinner
    var dataSpinnerCeleng = "Celengan Utama"



    override fun onCreateView(



        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_simpan, container, false)

        tvSimpan = view.findViewById(R.id.TVsimpancelengan) as TextView

        teksCalendar = view.findViewById(R.id.ETcalendar) as TextView

        val macamtabungan = resources.getStringArray(R.array.jenisTabungan)

        spinnerCeleng = view.findViewById(R.id.spinner_celengan_simpan) as Spinner
        val adapter = ArrayAdapter(requireContext(),android.R.layout.simple_spinner_item, macamtabungan)
        spinnerCeleng.adapter = adapter

        spinnerCeleng.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                dataSpinnerCeleng = macamtabungan[p2]
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {

            }

        }

        etdebit = view.findViewById(R.id.ETjumlah) as EditText
        etCatatan = view.findViewById(R.id.ETcatatan) as EditText

        teksCalendar.setOnClickListener {
            val c = Calendar.getInstance()
            val year = c.get(Calendar.YEAR)
            val month = c.get(Calendar.MONTH)
            val day = c.get(Calendar.DAY_OF_MONTH)


            val dpd = DatePickerDialog(requireActivity(), { view, year, monthOfYear, dayOfMonth ->
                teksCalendar.setText("" + dayOfMonth + " " + MONTH[monthOfYear] + " " + year)

            }, year, month, day)

            dpd.show()
        }


        imageBack = view.findViewById(R.id.BTclose2) as ImageView

        imageBack.setOnClickListener{
            loadFragment(HalamanUtama())
        }

        tvSimpan.setOnClickListener {
            if(etdebit.text.trim().length > 0 && etCatatan.text.trim().length > 0 && !teksCalendar.text.equals("set tanggal")){
                NetworkConfig().getServiceCeleng().addTabungan("0",etdebit.text.toString(), etCatatan.text.toString(), teksCalendar.text.toString(), dataSpinnerCeleng, 1).
                enqueue(object  : Callback<Tabungan> {
                    override fun onResponse(call: Call<Tabungan>, response: Response<Tabungan>) {
                        try {
                            if (response!!.body()!!.code == 1){
                                startActivity(Intent(requireActivity(),Celengan_history::class.java))
                            }else{
                                Toast.makeText(requireContext(), "Data Kosong", Toast.LENGTH_SHORT).show()
                            }
                        }catch (e:java.lang.Exception){
                            e.printStackTrace()
                        }
                    }

                    override fun onFailure(call: Call<Tabungan>, t: Throwable) {
                        Toast.makeText(requireContext(), "no internet access", Toast.LENGTH_SHORT).show()
                    }

                })
            }else{
                Toast.makeText(requireActivity(), "data masih kosong", Toast.LENGTH_SHORT).show()
            }
        }

        return view
    }

    fun loadFragment(fragment: Fragment){
        val transaction = requireActivity().supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container,fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

}