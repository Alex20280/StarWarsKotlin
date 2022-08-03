package com.sigma.internship.mvvm.data.db.entities

import androidx.room.*
import com.sigma.internship.mvvm.data.db.convertermodels.Cast
import com.sigma.internship.mvvm.data.db.convertermodels.Results
import com.sigma.internship.mvvm.data.db.converters.ResultsConverter

@Entity(tableName = "response")
data class ResultDbModel(
    @PrimaryKey(autoGenerate = false)
    var page: Int,
    @ColumnInfo(name = "results")
    var results: Results
)

{
    constructor() : this(0, Results(MovieDbModel()))
}
