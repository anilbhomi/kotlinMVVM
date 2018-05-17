package com.example.ebpearls.kotlinmvvm.viewModel

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.databinding.ObservableField
import android.util.Log
import com.example.ebpearls.kotlinmvvm.model.LoginModel
import com.example.ebpearls.kotlinmvvm.remote.LoginRepository


class LoginViewModel : ViewModel() {

    var email = ObservableField("")
    var password = ObservableField("")

    var response: MutableLiveData<LoginModel>

    private val loginRepository: LoginRepository

    init {
        loginRepository = LoginRepository()
        response = loginRepository.getData(email.get()!!, password.get()!!)
    }

    fun login() {
        response = loginRepository.getData(email.get()!!, password.get()!!)
    }
}