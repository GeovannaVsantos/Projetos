package com.gevi.sqlcomroom.data

class UserRepository (private val userDao: UserDao){

    val selectUsers = userDao.selectUsers()


    fun adicionarUsers(usuario: Usuario) {
        userDao.addUser(usuario)
    }
}