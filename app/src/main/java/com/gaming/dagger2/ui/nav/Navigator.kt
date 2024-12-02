package com.gaming.dagger2.ui.nav

import androidx.navigation.NavOptionsBuilder
import com.gaming.dagger2.ui.Destination
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.receiveAsFlow
import javax.inject.Inject

interface Navigator {
    val startDestination: Destination
    val navigationActions: Flow<NavigationAction>

    suspend fun navigate(
        destination: Destination,
        navOptionsBuilder: NavOptionsBuilder.() -> Unit = {}
    )

    suspend fun navigateUp()
}

class DefaultNavigator constructor(
    override val startDestination: Destination
) : Navigator {

    private val _navigationActions = Channel<NavigationAction>()
    override val navigationActions = _navigationActions.receiveAsFlow()

    override suspend fun navigate(
        destination: Destination,
        navOptionsBuilder: NavOptionsBuilder.() -> Unit
    ) {
        _navigationActions.send(
            NavigationAction.Navigate(
                destination, navOptionsBuilder
            )
        )
    }

    override suspend fun navigateUp() {
        _navigationActions.send(NavigationAction.NavigateUp)
    }

}