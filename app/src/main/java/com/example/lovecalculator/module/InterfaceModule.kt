package com.example.lovecalculator.module

import com.example.lovecalculator.presenter.MainFragmentPresenter
import com.example.lovecalculator.ui.MainActivity
import com.example.lovecalculator.ui.MainFragment
import com.example.lovecalculator.view.MainView
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
abstract class InterfaceModule {
    @Binds
    abstract fun bindLoveView(mainFragment: MainFragment):MainView
}