package com.example.lovecalculator.module

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.room.Room
import com.example.lovecalculator.model.LoveApi
import com.example.lovecalculator.model.ShearedPref
import com.example.lovecalculator.model.ShearedPref.Companion.PREF_NAME
import com.example.lovecalculator.model.room.AppDatabase
import com.example.lovecalculator.model.room.LoveDao
import com.example.lovecalculator.presenter.MainFragmentPresenter
import com.example.lovecalculator.view.MainView
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Singleton
    @Provides
    fun provideApi(): LoveApi{
        return Retrofit.Builder().baseUrl("https://love-calculator.p.rapidapi.com/")
            .addConverterFactory(GsonConverterFactory.create()).build().create(LoveApi::class.java)
    }
    @Provides
    fun provideLoveDataBase(@ApplicationContext context: Context): AppDatabase{
        return Room.databaseBuilder(context, AppDatabase::class.java, "love-file").allowMainThreadQueries().build()
    }

    @Provides
    fun provideLoveDao(appDatabase: AppDatabase):LoveDao{
        return appDatabase.loveDao()
    }

    @Provides
    fun provideSharedPreferences(context: Context): ShearedPref {
        return ShearedPref(context)
    }

}