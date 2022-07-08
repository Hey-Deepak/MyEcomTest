package com.dc.myecom.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dc.myecom.data.User
import com.dc.myecom.data.UserDatabse
import com.dc.myecom.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(
    application: Application,
private var repository: UserRepository
    ) : AndroidViewModel(application) {


    init {

        viewModelScope.launch{
            val userDao = UserDatabse.getDatabase(application).userDao()
            repository = UserRepository(userDao)

            val readAllData: List<User>? = async { repository.readAllData().value }.await()

            Log.d("TAG", "readAllData userViewModel: ${readAllData} ")
        }

    }

    fun addUser(user: User) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addUser(user)
        }
    }
}