package com.gaming.dagger2.ui.viewmodel

import android.util.Log
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

    override fun onCleared() {
        Log.d("ViewModel","DetailCleared")
        super.onCleared()
    }
}