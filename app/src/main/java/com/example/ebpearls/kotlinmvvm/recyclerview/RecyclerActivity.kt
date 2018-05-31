package com.example.ebpearls.kotlinmvvm.recyclerview

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.android.databinding.library.baseAdapters.BR
import com.example.ebpearls.kotlinmvvm.R

class RecyclerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler)

        val items = listOf(
                Model("Saint Petersburg" ),
                Model("Saint Petersburg" ),
                Model("Saint Petersburg" ),
                Model("Saint Petersburg" ))
        val recyclerView: RecyclerView = findViewById(R.id.list)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = WeatherAdapter(items)
    }

    class WeatherAdapter(val data: List<Model>): RecyclerView.Adapter<WeatherViewHolder>() {
        override fun onBindViewHolder(holder: WeatherViewHolder, position: Int) {
            holder.bind(data[position])
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val binding: ViewDataBinding =
                    DataBindingUtil.inflate(layoutInflater, R.layout.weather_row, parent, false)

            return WeatherViewHolder(binding)
        }

        override fun getItemCount(): Int = data.size
    }

    class WeatherViewHolder(val binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(data: Any) {
            binding.setVariable(BR.data, data)
            binding.executePendingBindings()
        }
    }
}
