package com.gaming.dagger2.ui

import kotlinx.serialization.Serializable

sealed interface Destination {
    @Serializable
    data object HomeGraph : Destination

    @Serializable
    data object AuthGraph : Destination

    @Serializable
    data object LoginScreen : Destination

    @Serializable
    data object HomeScreen : Destination

    @Serializable
    data class DetailsScreen(val id:String) : Destination
}