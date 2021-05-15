package com.prathyusha.skillapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.prathyusha.skillapp.R
import com.prathyusha.skillapp.fragment.HomeFragment
import com.prathyusha.skillapp.model.Model

class HomeRecyclerViewAdapter(val arrayList: ArrayList<Model>, val context: HomeFragment) : RecyclerView.Adapter<HomeRecyclerViewAdapter.ViewHolder>(){

    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){

        val txtTitle = itemView.findViewById(R.id.txtTitle) as TextView
        val txtDesc  = itemView.findViewById(R.id.txtDesc) as TextView
        val imgRecycler=itemView.findViewById(R.id.imgRecycler) as ImageView
        val txtName = itemView.findViewById(R.id.txtName) as TextView
        val txtDays = itemView.findViewById(R.id.txtDays) as TextView
        val share=itemView.findViewById(R.id.share) as ImageView
        val favourite = itemView.findViewById(R.id.favourite) as ImageView

        fun bindItems(model : Model){
            txtTitle.text=model .title
            txtDesc.text=model.desc
            imgRecycler.setImageResource(model.image)

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v= LayoutInflater.from(parent.context).inflate(R.layout.recyler_home,parent,false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItems(arrayList[position])
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }
}

