package com.example.mvvmpracticegoogle.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.mvvmpracticegoogle.R
import com.example.mvvmpracticegoogle.utils.User
import com.example.mvvmpracticegoogle.viewmodel.LiveDataViewModel
import kotlinx.android.synthetic.main.activity_live_data.*

class LiveDataActivity : AppCompatActivity() {

    var numero : Int = 0
    lateinit var viewModel : LiveDataViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_live_data)

        setUpView()
    }

    fun setUpView() {

        viewModel = ViewModelProviders.of(this).get(LiveDataViewModel::class.java)

        btSave.setOnClickListener {
            if (numero == 0) {
                val user = User()
                user.nombre = "Alberto"
                user.edad = "30"
                viewModel.addUser(user)
            }
            if (numero == 1) {
                val user = User()
                user.nombre = "Juan"
                user.edad = "36"
                viewModel.addUser(user)
            }
            if (numero == 2) {
                val user = User()
                user.nombre = "Jose"
                user.edad = "42"
                viewModel.addUser(user)
            }
            numero++
        }

        // Creamos el observador para que se dispare cada vez que la lista de usuarios cambie, aquí
        // aún no esta suscrito al observable
        val listObserver = Observer<List<User>> { userList ->
            run {
                var text = ""
                for (user in userList) {
                    text += "${user.nombre} ${user.edad} \n"
                }

                tvLiveData.text = text
            }
        }

        // Suscribimos el observer al observable
        viewModel.getUserList().observe(this@LiveDataActivity, listObserver)
    }
}
