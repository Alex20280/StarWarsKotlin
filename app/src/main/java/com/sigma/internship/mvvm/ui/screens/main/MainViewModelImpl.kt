package com.sigma.internship.mvvm.ui.screens.main

import androidx.lifecycle.MutableLiveData
import com.sigma.internship.mvvm.data.db.dao.UsersDao
import com.sigma.internship.mvvm.data.db.entities.UserEntity
import com.sigma.internship.mvvm.data.entities.UserLocalModel

class MainViewModelImpl(private val dao: UsersDao): MainViewModel() {

    override val getUserResponse = MutableLiveData<List<UserLocalModel>>()

    override fun adduser(firstName: String, lastName: String) {
        launchWithProgress(isLoading){
            dao.saveUser(UserEntity(firstName = firstName, lastName = lastName))
        }
    }

    override fun getUsers() {
       launchWithProgress(isLoading){
           val users = dao.getUsers().map { it.convertToLocal() }
           getUserResponse.postValue(users)
       }
    }
}