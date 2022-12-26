package com.bintang.nylngi

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView

class CelenganAdapter (private val mList: List<CelenganModel>, val context: Context) : RecyclerView.Adapter<CelenganAdapter.ViewHolde>() {



    class ViewHolde(ItemView: View) : RecyclerView.ViewHolder(ItemView){
        val imageView: ImageView = itemView.findViewById(R.id.IVcelengan)
        val textViewjudul: TextView = itemView.findViewById(R.id.TVjudulcelengan)
        val textViewdesc: TextView = itemView.findViewById(R.id.TVdescCelengan)
        val CLceleng: ConstraintLayout = itemView.findViewById(R.id.CLcelengan)


    }





    override fun getItemCount(): Int {
        return mList.size
    }

    override fun onBindViewHolder(holder: ViewHolde, position: Int) {
        val CelenganModel = mList[position]
        holder.imageView.setImageResource(CelenganModel.image)
        holder.textViewjudul.text = CelenganModel.Judul
        holder.textViewdesc.text = CelenganModel.Deskripsi




        holder.CLceleng.setOnClickListener{
            if(position == 0){
                context.startActivity(Intent(context, Celengan_history::class.java))
            }else if(position == 1){
                context.startActivity(Intent(context, CelenganBabiYmir::class.java))
            }else{
                context.startActivity(Intent(context, CelenganMasaDepan::class.java))
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolde {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_celengan, parent, false)

        return CelenganAdapter.ViewHolde(view)
    }


}