package com.gaming.dagger2

import androidx.lifecycle.ViewModel
import com.gaming.dagger2.ui.nav.Navigator
import javax.inject.Inject

class MainViewModel @Inject constructor(
    val navigator: Navigator
): ViewModel() {

}