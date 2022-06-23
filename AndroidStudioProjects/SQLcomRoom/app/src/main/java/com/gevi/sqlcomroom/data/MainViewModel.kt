package com.gevi.sqlcomroom.data

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel (application: Application) : AndroidViewModel(application){

    val selectUser: LiveData<List<Usuario>>
    val repository: UserRepository

    init {
        val userDao = UserDataBase.getDatabase(application).userDao()
        repository = UserRepository(userDao)

        selectUser = repository.selectUsers
    }

    fun addUser(usuario: Usuario) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.adicionarUsers(usuario)
        }
    }
}