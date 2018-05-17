package com.example.ebpearls.kotlinmvvm.remote


import com.example.ebpearls.kotlinmvvm.model.LoginModel
import retrofit2.Call
import retrofit2.http.POST
import retrofit2.http.Query

interface ApiClient {

    @POST("/api/login")
    fun userLogin(@Query("email") email: String, @Query("password") password: String): Call<LoginModel>
}