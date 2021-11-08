package  com.sigma.internship.mvvm.ui.base

import androidx.lifecycle.LiveData

interface BaseVM {

    val isLoading: LiveData<Boolean>
}