package com.sigma.internship.mvvm.data.entities

data class UserLocalModel(
    val userFirstName: String,
    val userLastName: String
) {
    fun getUserFullName(): String{
        return "$userFirstName $userLastName"
    }
}
