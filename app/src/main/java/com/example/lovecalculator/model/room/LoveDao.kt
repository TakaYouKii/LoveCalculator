package com.example.lovecalculator.model.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.lovecalculator.model.LoveModel

@Dao
interface LoveDao {

    @Insert
    fun insert(loveModel: LoveModel)
    @Delete
    fun delete(loveModel: LoveModel)

    @Query("SELECT * FROM love_table order by id DESC")
    fun getAll(): List<LoveModel>
}