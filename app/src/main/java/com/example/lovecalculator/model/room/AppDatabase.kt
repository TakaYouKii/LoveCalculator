package com.example.lovecalculator.model.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.lovecalculator.model.LoveDateTimeModel
import com.example.lovecalculator.model.LoveModel

@Database(entities = [LoveModel::class, LoveDateTimeModel::class], version = 2)
abstract class AppDatabase: RoomDatabase() {
    abstract fun loveDao(): LoveDao
    abstract fun loveDatetimeDao():LoveDateTimeDao
}