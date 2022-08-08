package com.sigma.internship.mvvm.data.db.convertermodels

import androidx.room.Embedded

data class Cast(
    @Embedded
    var name: String,
    var profile_path: String,
    var character: String
)
