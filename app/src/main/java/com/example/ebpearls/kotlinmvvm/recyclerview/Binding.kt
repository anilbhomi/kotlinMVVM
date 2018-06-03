package com.example.ebpearls.kotlinmvvm.recyclerview

import android.databinding.BindingAdapter
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log

object Binding {
    @BindingAdapter("adapter")
    @JvmStatic
    fun setAdapterToRecyclerView(recyclerView: RecyclerView,items:List<Model>){
        recyclerView.adapter = WeatherAdapter(items)
    }
}