package com.example.lovecalculator.model.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.lovecalculator.model.LoveDateTimeModel
import com.example.lovecalculator.model.LoveModel
@Dao
interface LoveDateTimeDao {
    @Insert
    fun insert(loveDateTimeModel: LoveDateTimeModel)
    @Delete
    fun delete(loveDateTimeModel: LoveDateTimeModel)

    @Query("SELECT * FROM love_date_time order by id DESC")
    fun getAll(): List<LoveDateTimeModel>
}