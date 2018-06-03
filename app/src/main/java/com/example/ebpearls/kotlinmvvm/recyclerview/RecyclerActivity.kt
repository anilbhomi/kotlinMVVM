package com.example.ebpearls.kotlinmvvm.recyclerview

import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import com.example.ebpearls.kotlinmvvm.R
import com.example.ebpearls.kotlinmvvm.databinding.ActivityRecyclerBinding

class RecyclerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val activityRecyclerBinding = DataBindingUtil.setContentView<ActivityRecyclerBinding>(this, R.layout.activity_recycler)
        val recyclerView: RecyclerView = findViewById(R.id.list)
        recyclerView.layoutManager = GridLayoutManager(this,2)
        activityRecyclerBinding.vm = MyViewModel()
    }
}
