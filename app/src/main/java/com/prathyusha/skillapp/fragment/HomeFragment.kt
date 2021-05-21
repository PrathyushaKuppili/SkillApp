package com.prathyusha.skillapp.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.prathyusha.skillapp.R
import com.prathyusha.skillapp.adapter.HomeRecyclerViewAdapter
import com.prathyusha.skillapp.model.Model


class HomeFragment : Fragment() {

    lateinit var homeRecycler :RecyclerView

    lateinit var layoutManager: RecyclerView.LayoutManager

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view=inflater.inflate(R.layout.fragment_home, container, false)

        homeRecycler= view.findViewById(R.id.homeRecycler)
      //  layoutManager=LinearLayoutManager(activity)

        val arrayList = ArrayList<Model>()

        //Need to pass the data in the arraylist

        arrayList.add(Model("The Ulitimate  guide to acting coding interview for Data science","The Ulitimate  guide to acting coding interview for Data scienceThe Ulitimate  guide to acting coding interview for Data scienceThe Ulitimate  guide to interview for Data scienceThe Ulitimate  guide to ",R.drawable.python,"Kdnuggets","10 days"))
        arrayList.add(Model("The Ulitimate  guide to acting coding interview for Data science","The Ulitimate  guide to acting coding interview for Data scienceThe Ulitimate  guide to acting coding interview for Data scienceThe Ulitimate  guide to interview for Data scienceThe Ulitimate  guide to ",R.drawable.secondrect,"Kdnuggets","10 days"))
        arrayList.add(Model("The Ulitimate  guide to acting coding interview for Data science","The Ulitimate  guide to acting coding interview for Data scienceThe Ulitimate  guide to acting coding interview for Data scienceThe Ulitimate  guide to interview for Data scienceThe Ulitimate  guide to ",R.drawable.thirdrectangle,"Kdnuggets","10 days"))
        arrayList.add(Model("The Ulitimate  guide to acting coding interview for Data science","The Ulitimate  guide to acting coding interview for Data scienceThe Ulitimate  guide to acting coding interview for Data scienceThe Ulitimate  guide to interview for Data scienceThe Ulitimate  guide to ",R.drawable.secondrect,"Kdnuggets","10 days"))
        arrayList.add(Model("The Ulitimate  guide to acting coding interview for Data science","The Ulitimate  guide to acting coding interview for Data scienceThe Ulitimate  guide to acting coding interview for Data scienceThe Ulitimate  guide to interview for Data scienceThe Ulitimate  guide to ",R.drawable.thirdrectangle,"Kdnuggets","10 days"))

        val myAdapter = HomeRecyclerViewAdapter(arrayList,this)

        homeRecycler.layoutManager=LinearLayoutManager(activity)
        homeRecycler.adapter=myAdapter

        return view
    }

}