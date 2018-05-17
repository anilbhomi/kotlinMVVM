package com.example.ebpearls.kotlinmvvm.model

import com.google.gson.annotations.SerializedName

class LoginModel {

    @SerializedName("status")
    var status: String? = null
    @SerializedName("message")
    var message: String? = null
}