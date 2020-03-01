package com.example.mvvmpracticegoogle.ui

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.mvvmpracticegoogle.R
import com.example.mvvmpracticegoogle.databinding.ActivityDataBindingBinding
import com.example.mvvmpracticegoogle.utils.User

class DataBindingActivity : AppCompatActivity() {

    lateinit var user : User

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Cuando utilizamos DataBinding no se hace la conexión de esta forma
        //setContentView(R.layout.activity_data_binding)

        val binding : ActivityDataBindingBinding = DataBindingUtil
            .setContentView(this@DataBindingActivity, R.layout.activity_data_binding)

        user = User("Alberto", "30")

        // Para asociar la variable user de esta activity con la variable userDBinding del layout
        binding.userDBinding = user
    }
}
