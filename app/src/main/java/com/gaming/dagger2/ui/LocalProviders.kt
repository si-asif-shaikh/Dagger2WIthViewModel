package com.gaming.dagger2.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.lifecycle.ViewModelProvider

val LocalViewModelFactory = staticCompositionLocalOf<ViewModelProvider.Factory> { error("No Provider found!") }

@Composable
internal fun LocalProvider(
    viewModelFactory: ViewModelProvider.Factory,
    component: @Composable () -> Unit,
) {
    CompositionLocalProvider(
        LocalViewModelFactory provides viewModelFactory
    ) {
        component()
    }
}