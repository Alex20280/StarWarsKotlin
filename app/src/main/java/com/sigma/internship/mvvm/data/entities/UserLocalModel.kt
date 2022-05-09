package com.sigma.internship.mvvm.data.entities

data class UserLocalModel(

    //model for db
    val userFirstName: String,
    val userLastName: String
) {
    fun getUserFullName(): String{
        return "$userFirstName $userLastName"
    }
}
