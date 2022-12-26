package com.bintang.nylngi

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bintang.nylngi.data.TabunganItem

class CelenganHistoryAdapter(private val mList: List<TabunganItem>) : RecyclerView.Adapter<CelenganHistoryAdapter.ViewHolde>() {

    lateinit var context: Context

    class ViewHolde(ItemView: View) : RecyclerView.ViewHolder(ItemView){

        val textViewjudul: TextView = itemView.findViewById(R.id.TVIDRhistori)
        val textViewtanggal: TextView = itemView.findViewById(R.id.TVtanggalHistory)
        val textViewcatatan: TextView = itemView.findViewById(R.id.TVcatatanHistory)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolde {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_history_celengan, parent, false)
        context = parent.context
        return CelenganHistoryAdapter.ViewHolde(view)
    }

    override fun onBindViewHolder(holder: ViewHolde, position: Int) {
        val CelenganHistoryModel = mList[position]
        if(CelenganHistoryModel.debit.toInt() > 0) {
            val drawable = ContextCompat.getDrawable(context, R.drawable.ic_baseline_horizontal_rule_24)
            holder.textViewjudul.setCompoundDrawablesWithIntrinsicBounds(drawable, null, null, null)
            holder.textViewjudul.text = CelenganHistoryModel.debit
        } else {
            val drawable = ContextCompat.getDrawable(context, R.drawable.ic_baseline_add_24_white)
            holder.textViewjudul.setCompoundDrawablesWithIntrinsicBounds(drawable, null, null, null)
            holder.textViewjudul.text = CelenganHistoryModel.kredit
        }
        holder.textViewtanggal.text = CelenganHistoryModel.tanggal
        holder.textViewcatatan.text = CelenganHistoryModel.catatan
    }

    override fun getItemCount(): Int {
        return mList.size
    }


}