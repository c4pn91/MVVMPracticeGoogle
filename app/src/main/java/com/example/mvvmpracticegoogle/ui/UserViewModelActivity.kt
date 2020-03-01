package com.example.mvvmpracticegoogle.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import com.example.mvvmpracticegoogle.R
import com.example.mvvmpracticegoogle.utils.User
import com.example.mvvmpracticegoogle.viewmodel.UserViewModel
import kotlinx.android.synthetic.main.activity_user_view_model.*

class UserViewModelActivity : AppCompatActivity() {

    var userList : ArrayList<User> = ArrayList()
    lateinit var userViewModel : UserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_view_model)

        setUpView()
    }

    fun setUpView() {

        userViewModel = ViewModelProviders.of(this).get(UserViewModel::class.java)

        btSalvar.setOnClickListener {
            var user = User()
            user.edad = etEdad.text.toString()
            user.nombre = etNombre.text.toString()

            // Add new user to list
            userList.add(user)

            userViewModel.addUser(user)
        }

        btVer.setOnClickListener {
            var text = ""

            for (user in userList) {
                text += "${user.nombre} ${user.edad} \n"
            }

            tvUser.text = text

            var text2 = ""
            for (user2 in userViewModel.userList) {
                text2 += "${user2.nombre} ${user2.edad} \n"
            }

            tvUserViewModel.text = text2
        }
    }
}
