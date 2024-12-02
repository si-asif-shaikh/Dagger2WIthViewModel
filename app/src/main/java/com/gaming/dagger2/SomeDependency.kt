package com.gaming.dagger2

import android.util.Log
import javax.inject.Inject

class SomeDependency @Inject constructor() {
    fun invoke(){
        Log.d("MyViewModel","Something")
    }
}