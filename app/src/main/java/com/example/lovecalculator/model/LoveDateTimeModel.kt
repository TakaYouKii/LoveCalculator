package com.example.lovecalculator.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "love_date_time")
data class LoveDateTimeModel(
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null,
    var loveModelId: String,
    var dateTime: String
):Serializable
