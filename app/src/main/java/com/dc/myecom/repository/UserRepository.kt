package com.dc.myecom.repository

import com.dc.myecom.data.User
import com.dc.myecom.data.UserDao
import javax.inject.Inject

class UserRepository @Inject constructor(
    private val userDao: UserDao
) {
   // val readAllData: LiveData<List<User>>? = userDao.readAllData()

    fun readAllData(): List<User>{
        return userDao.readAllData()
    }

    suspend fun addUser(user: User){
        userDao.addUser(user)
    }
}