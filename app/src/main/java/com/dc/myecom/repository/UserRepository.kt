package com.dc.myecom.repository

import androidx.lifecycle.LiveData
import com.dc.myecom.data.User
import com.dc.myecom.data.UserDao

class UserRepository(
    private val userDao: UserDao
) {
    val readAllData: LiveData<List<User>> = userDao.readAllData()

    /*fun readAllData(): LiveData<List<User>>{
        userDao.readAllData()
    }*/

    suspend fun addUser(user: User){
        userDao.addUser(user)
    }
}