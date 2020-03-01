package com.example.mvvmpracticegoogle.viewmodel

import androidx.lifecycle.ViewModel
import com.example.mvvmpracticegoogle.utils.User

class UserViewModel : ViewModel {
    var userList : MutableList<User>

    constructor() {
        userList = ArrayList()
    }

    fun addUser(user: User) {
        userList.add(user)
    }
}