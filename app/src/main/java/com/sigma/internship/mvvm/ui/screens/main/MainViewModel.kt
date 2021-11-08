package com.sigma.internship.mvvm.ui.screens.main

import androidx.lifecycle.LiveData
import com.sigma.internship.mvvm.data.entities.UserLocalModel
import com.sigma.internship.mvvm.ui.base.BaseViewModel

abstract class MainViewModel: BaseViewModel() {

    abstract fun adduser(firstName: String, lastName: String)
    abstract fun getUsers()
    abstract val getUserResponse: LiveData<List<UserLocalModel>>
}