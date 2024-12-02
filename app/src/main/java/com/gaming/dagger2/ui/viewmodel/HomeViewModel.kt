package com.gaming.dagger2.ui.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gaming.dagger2.SomeDependency
import com.gaming.dagger2.ui.Destination
import com.gaming.dagger2.ui.nav.Navigator
import kotlinx.coroutines.launch
import javax.inject.Inject

class HomeViewModel @Inject constructor(
    private val someDependency: SomeDependency,
    private val navigator: Navigator
) : ViewModel() {

    fun navigationToDetails(id:String){
        viewModelScope.launch {
            navigator.navigate(
                destination = Destination.DetailsScreen(id),
            )
        }
    }


    fun printSomething(){
        someDependency.invoke()
    }

    fun getGreeting(): String = someDependency.greet()

    override fun onCleared() {
        Log.d("ViewModel","HomeCleared")
        super.onCleared()
    }
}