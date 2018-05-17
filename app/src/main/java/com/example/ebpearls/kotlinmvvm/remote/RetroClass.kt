package com.example.ebpearls.kotlinmvvm.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetroClass {
    private val BASE_URL = "http://wfp.robustitconcepts.com/"

    private fun getRetroInstance(): Retrofit {

        return Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build()
    }

    fun getApiService(): ApiClient {

        return getRetroInstance().create(ApiClient::class.java)

    }

}