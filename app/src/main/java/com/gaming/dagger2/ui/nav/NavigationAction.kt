package com.gaming.dagger2.ui.nav

import androidx.navigation.NavOptionsBuilder
import com.gaming.dagger2.ui.Destination

sealed interface NavigationAction {

    data class Navigate(
        val destination: Destination,
        val navOption: NavOptionsBuilder.() -> Unit = {}
    ) : NavigationAction

    data object NavigateUp: NavigationAction
}