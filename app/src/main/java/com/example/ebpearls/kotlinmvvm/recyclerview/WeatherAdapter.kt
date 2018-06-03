package com.example.ebpearls.kotlinmvvm.recyclerview

import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import com.example.ebpearls.kotlinmvvm.BR
import com.example.ebpearls.kotlinmvvm.R
import com.example.ebpearls.kotlinmvvm.databinding.WeatherRowBinding
import com.example.ebpearls.kotlinmvvm.model.LoginModel
import java.util.ArrayList

class WeatherAdapter(val data: List<Model>) : RecyclerView.Adapter<WeatherViewHolder>() {
    override fun onBindViewHolder(holder: WeatherViewHolder, position: Int) {
        val model: Model = data[position]
        holder.bind(model)

        val data: WeatherRowBinding = holder.getDataBinding()
        data.handler = object : itemClickHandler {
            override fun onItemClick(view: View) {
                if (view is CheckBox) {
                    val check: CheckBox = view as CheckBox
                    if (check.isChecked) {
                      Log.i("debug123","${position}==>checked")
                    } else {
                      Log.i("debug123","${position}==>unchecked")
                    }
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: WeatherRowBinding =
                WeatherRowBinding.inflate(layoutInflater, parent, false)

        return WeatherViewHolder(binding)
    }

    override fun getItemCount(): Int = data.size


}

class WeatherViewHolder(val binding: WeatherRowBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(data: Any) {
        binding.setVariable(BR.data, data)
        binding.executePendingBindings()
    }

    fun getDataBinding(): WeatherRowBinding {
        return binding
    }
}

