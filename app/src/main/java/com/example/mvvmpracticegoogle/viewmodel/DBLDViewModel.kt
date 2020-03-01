package com.example.mvvmpracticegoogle.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mvvmpracticegoogle.utils.User

class DBLDViewModel : ViewModel() {
    var user : MutableLiveData<User> = MutableLiveData()

    fun setUser(user : User) {
        this.user.value = user
    }

    fun updateUser() {
        val user = User("NuevoNombre", "NuevaEdad")
        this.user.value = user
    }
}