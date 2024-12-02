package com.gaming.dagger2

import android.util.Log
import androidx.lifecycle.ViewModel
import javax.inject.Inject

class MyViewModel @Inject constructor(
    private val someDependency: SomeDependency
) : ViewModel() {
    // ViewModel logic

    fun printSomething(){
        someDependency.invoke()
    }

    fun getGreeting(): String = someDependency.greet()
}