package com.example.ebpearls.kotlinmvvm.recyclerview

import android.arch.lifecycle.ViewModel
import android.databinding.ObservableField

class MyViewModel: ViewModel() {

    var list=ObservableField(listOf(
                    Model("Saint Petersburg" ),
                    Model("Saint Petersburg" ),
                    Model("Saint Petersburg" ),
                    Model("Saint Petersburg" )))



}