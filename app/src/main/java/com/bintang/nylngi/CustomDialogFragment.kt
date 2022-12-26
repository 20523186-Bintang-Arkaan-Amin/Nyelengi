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
import androidx.fragment.app.DialogFragment

class CustomDialogFragment: DialogFragment() {

    lateinit var IVsavee: ImageView
    lateinit var IVcancel: ImageView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       var rootView : View = inflater.inflate(R.layout.fragment_edit_jumlahuang,container, false)



        IVsavee = rootView.findViewById(R.id.IVsaveEJU) as ImageView
        IVcancel = rootView.findViewById(R.id.IVcancelEJU) as ImageView

        IVcancel.setOnClickListener{
            dismiss()
        }

        IVsavee.setOnClickListener{
            dismiss()
        }

        return rootView
    }




}


