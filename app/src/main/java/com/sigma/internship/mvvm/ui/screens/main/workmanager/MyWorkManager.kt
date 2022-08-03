package com.sigma.internship.mvvm.ui.screens.main.workmanager

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters

//https://medium.com/androiddevelopers/workmanager-meets-kotlin-b9ad02f7405e

class MyWorkManager(context: Context, workParameters: WorkerParameters) : Worker(context,workParameters) {
    override fun doWork(): Result {
        TODO("Not yet implemented")
    }
}