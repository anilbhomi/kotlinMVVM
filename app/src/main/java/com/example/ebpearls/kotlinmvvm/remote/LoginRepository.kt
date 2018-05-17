package com.example.ebpearls.kotlinmvvm.remote

import android.arch.lifecycle.MutableLiveData
import android.util.Log
import com.example.ebpearls.kotlinmvvm.model.LoginModel


import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit


class LoginRepository {

    private val data = MutableLiveData<LoginModel>()

    fun getData(username: String, password: String): MutableLiveData<LoginModel> {

        val apiClient = RetroClass.getApiService()
        val call = apiClient.userLogin(username, password)
        call.enqueue(object : Callback<LoginModel> {
            override fun onResponse(call: Call<LoginModel>, response: Response<LoginModel>) {

                data.setValue(response.body())
            }

            override fun onFailure(call: Call<LoginModel>, t: Throwable) {

            }
        })
        return data
    }
}