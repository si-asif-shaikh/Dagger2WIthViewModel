package com.gaming.dagger2.di

import android.content.Context
import com.gaming.dagger2.ui.Destination
import com.gaming.dagger2.ui.nav.DefaultNavigator
import com.gaming.dagger2.ui.nav.Navigator
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(private val applicationContext: Context) {

    @Provides
    @Singleton
    fun provideApplicationContext(): Context = applicationContext

    @Provides
    @Singleton
    fun provideNavigation(): Navigator = DefaultNavigator(startDestination = Destination.AuthGraph)
}