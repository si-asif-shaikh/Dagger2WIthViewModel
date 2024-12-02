package com.gaming.dagger2.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.gaming.dagger2.MyViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(MyViewModel::class)
    abstract fun bindMyViewModel(myViewModel: MyViewModel): ViewModel

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}