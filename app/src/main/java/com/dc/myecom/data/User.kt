package com.dc.myecom.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_table")
data class User(
    val name: String = "",
    val emailId: String = "",
    @PrimaryKey
    val mobileNumber: String = "",
    val referralCode: String = "",
    val password: String = ""
)
