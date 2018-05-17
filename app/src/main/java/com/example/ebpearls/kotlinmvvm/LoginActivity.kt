package com.example.ebpearls.kotlinmvvm

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.example.ebpearls.kotlinmvvm.databinding.ActivityLoginBinding
import com.example.ebpearls.kotlinmvvm.model.LoginModel
import com.example.ebpearls.kotlinmvvm.viewModel.LoginViewModel

class LoginActivity : AppCompatActivity()  {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val activityLoginBinding = DataBindingUtil.setContentView<ActivityLoginBinding>(this, R.layout.activity_login)

        activityLoginBinding.loginviewmodel = LoginViewModel()

        activityLoginBinding.setLifecycleOwner(this)

        activityLoginBinding.loginviewmodel?.response?.observe(this, Observer<LoginModel> { loginModel ->
            activityLoginBinding.txtResponse.setText(loginModel?.message) })

    }
}
