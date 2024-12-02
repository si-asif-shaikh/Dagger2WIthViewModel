package com.gaming.dagger2

import android.app.Application
import com.gaming.dagger2.di.AppComponent
import com.gaming.dagger2.di.AppModule
import com.gaming.dagger2.di.DaggerAppComponent

class MyApp : Application() {

    lateinit var appComponent: AppComponent
        private set

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .build()
    }
}