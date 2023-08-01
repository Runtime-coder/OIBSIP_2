package com.macrogallant.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.macrogallant.data.DataSource
import com.macrogallant.unitconverter.LengthActivity
import com.macrogallant.unitconverter.R
import com.macrogallant.unitconverter.TemperatureActivity
import com.macrogallant.unitconverter.WeightActivity

class CardAdapter(private val context: Context, private val layout: Int):RecyclerView.Adapter<CardAdapter.CardViewHolder>() {
    class CardViewHolder(private val view: View): RecyclerView.ViewHolder(view){
        val imageView: ImageView? = view.findViewById(R.id.image)
        val dogName: TextView? = view.findViewById(R.id.name)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
            val adapterLayout =
                LayoutInflater.from(parent.context).inflate(R.layout.grid_list_item, parent, false)
            return CardViewHolder(adapterLayout)
    }


    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        val data = DataSource.names[position]
        holder.imageView?.setImageResource(data.imageResId)
        holder.dogName?.text = data.name

        if (position == 0) {
            holder.itemView.setOnClickListener {
                val intent = Intent(context, WeightActivity::class.java)
                context.startActivity(intent)
            }
        } else if (position == 1) {
            holder.itemView.setOnClickListener {
                val intent = Intent(context, LengthActivity::class.java)
                context.startActivity(intent)
            }
        }else if (position == 2){
            holder.itemView.setOnClickListener {
                val intent = Intent(context, TemperatureActivity::class.java)
                context.startActivity(intent)
            }
        }
    }

    override fun getItemCount(): Int {
        return DataSource.names.size
    }
}