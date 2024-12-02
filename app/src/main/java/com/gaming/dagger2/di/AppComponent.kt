package com.gaming.dagger2.di

import android.content.Context
import com.gaming.dagger2.MainActivity
import com.gaming.dagger2.MyFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ViewModelModule::class, AppModule::class])
interface AppComponent{
    fun inject(activity: MainActivity)
    fun inject(fragment: MyFragment)


    // Expose `Context` if needed elsewhere
    fun applicationContext(): Context
}