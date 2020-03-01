package com.example.mvvmpracticegoogle.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.example.mvvmpracticegoogle.R
import com.example.mvvmpracticegoogle.databinding.ActivityDbldBinding
import com.example.mvvmpracticegoogle.utils.User
import com.example.mvvmpracticegoogle.viewmodel.DBLDViewModel

class DBLDActivity : AppCompatActivity() {

    lateinit var viewModel : DBLDViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_dbld)

        val binding : ActivityDbldBinding = DataBindingUtil.setContentView(this,
            R.layout.activity_dbld)
        binding.setLifecycleOwner(this)

        viewModel = ViewModelProviders.of(this).get(DBLDViewModel::class.java)

        binding.varVModel = viewModel

        val user = User("Alberto, ", "30")
        viewModel.setUser(user)
    }
}
