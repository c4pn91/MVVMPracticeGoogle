package com.example.mvvmpracticegoogle.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mvvmpracticegoogle.utils.User
import kotlin.collections.ArrayList

class LiveDataViewModel : ViewModel() {

    // Observable object, va a enviar a los observadores de manera reactiva los cambios
    var userListLiveData : MutableLiveData<List<User>> = MutableLiveData()

    // Lista de usuarios que cada vez que haya un cambio no va a notificar porque
    // no es un observable (LiveData)
    var userList : MutableList<User> = ArrayList()

    // La diferencia entre LiveData y MutableLiveData es que el primero es de sólo lectura
    // y el segundo es de lectura y escritura
    fun getUserList() : LiveData<List<User>> {
        return userListLiveData
    }

    fun addUser(user : User) {
        // Agregamos el user a la lista qu no tiene Livedata
        userList.add(user)

        // Aregamos el user a la lista que tiene LiveData, tenemos .value y .postValue
        // .value : Si hay observadores activos, el valor es enviado y se debe llamar desde
        // el hilo principal de la UI
        // .postValue : Si necesitamos actualizar un valor desde un hilo en background
        userListLiveData.value = userList
    }
}