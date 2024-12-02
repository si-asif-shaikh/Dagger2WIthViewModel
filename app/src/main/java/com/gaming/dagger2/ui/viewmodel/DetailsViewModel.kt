package com.gaming.dagger2.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gaming.dagger2.ui.nav.Navigator
import kotlinx.coroutines.launch
import javax.inject.Inject

class DetailsViewModel @Inject constructor(
    private val navigator: Navigator
) : ViewModel() {

    fun goBack(){
        viewModelScope.launch {
            navigator.navigateUp()
        }
    }
}