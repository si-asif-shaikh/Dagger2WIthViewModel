package com.gaming.dagger2.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gaming.dagger2.ui.Destination
import com.gaming.dagger2.ui.nav.Navigator
import kotlinx.coroutines.launch
import javax.inject.Inject

class LoginViewModel @Inject constructor(
    private val navigator: Navigator
): ViewModel() {

    fun login(){
        viewModelScope.launch {
            navigator.navigate(
                destination = Destination.HomeGraph,
                navOptionsBuilder = {
                    popUpTo(Destination.AuthGraph){
                        inclusive = true
                    }
                }
            )
        }
    }
}