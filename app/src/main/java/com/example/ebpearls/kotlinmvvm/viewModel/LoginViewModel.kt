package com.example.ebpearls.kotlinmvvm.viewModel

import android.R
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.databinding.BindingAdapter
import android.databinding.ObservableField
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Spinner
import com.example.ebpearls.kotlinmvvm.model.LoginModel
import com.example.ebpearls.kotlinmvvm.remote.LoginRepository


class LoginViewModel() : ViewModel() {

    val quantityEntries=ObservableField<List<Int>>()
    var email = ObservableField("")
    var password = ObservableField("")
    var response: MutableLiveData<LoginModel>

    private val loginRepository: LoginRepository

    init {

        loginRepository = LoginRepository()
        response = loginRepository.getData(email.get()!!, password.get()!!)
    }

    fun login() {
        val a:List<Int> = listOf(1,2,3,4,5,6)
        quantityEntries.set(a)
        response = loginRepository.getData(email.get()!!, password.get()!!)
    }

    companion object {
        @BindingAdapter("entries")
        @JvmStatic
        fun setEntries(spinner: Spinner,entries: List<Int>?) {
            if (entries != null) {
                val arrayAdapter = ArrayAdapter(spinner.context, R.layout.simple_spinner_item, entries)
                arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                spinner.adapter = arrayAdapter
            }
        }
    }

}