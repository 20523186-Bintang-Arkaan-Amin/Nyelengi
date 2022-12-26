package com.bintang.nylngi

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class pencapaianAdapter (private val mList: List<pencapaianModel>) : RecyclerView.Adapter<pencapaianAdapter.ViewHolde>(){

    class ViewHolde(ItemView:View) : RecyclerView.ViewHolder(ItemView){
        val imageView: ImageView = itemView.findViewById(R.id.IVupload)
        val textViewjudul: TextView = itemView.findViewById(R.id.TVjudul)
        val textViewdesc: TextView = itemView.findViewById(R.id.TVdesc)
        val checkBox: CheckBox = itemView.findViewById(R.id.checkBox)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolde {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_capaian, parent, false)

        return ViewHolde(view)
    }

    override fun onBindViewHolder(holder: ViewHolde, position: Int) {
        val pencapaianModel = mList[position]
        holder.imageView.setImageResource(pencapaianModel.image)
        holder.textViewjudul.text = pencapaianModel.Judul
        holder.textViewdesc.text = pencapaianModel.Deskripsi
        holder.checkBox.isChecked = pencapaianModel.checkbox
    }

    override fun getItemCount(): Int {
        return mList.size
    }

}