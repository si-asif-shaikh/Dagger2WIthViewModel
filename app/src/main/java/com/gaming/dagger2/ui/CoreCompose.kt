package com.gaming.dagger2.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.gaming.dagger2.MainViewModel
import com.gaming.dagger2.ui.nav.NavigationAction
import com.gaming.dagger2.ui.viewmodel.DetailsViewModel
import com.gaming.dagger2.ui.viewmodel.HomeViewModel
import com.gaming.dagger2.ui.viewmodel.LoginViewModel
import java.util.UUID

@Composable
fun CoreCompose(
    viewModelFactory: ViewModelProvider.Factory
) {

    val mainViewModel: MainViewModel = viewModel(factory = viewModelFactory)

    LocalProvider(viewModelFactory) {

        Scaffold(
            modifier = Modifier.navigationBarsPadding()
        ) { innerPadding ->

            val navController = rememberNavController()
            val navigator = mainViewModel.navigator
            ObserverAsEvent(flow = navigator.navigationActions) { action ->
                when (action) {
                    is NavigationAction.Navigate -> {
                        navController.navigate(action.destination) {
                            action.navOption(this)
                        }
                    }

                    NavigationAction.NavigateUp -> navController.navigateUp()
                }
            }

            NavHost(
                modifier = Modifier.padding(innerPadding),
                navController = navController,
                startDestination = navigator.startDestination
            ) {
                navigation<Destination.AuthGraph>(
                    startDestination = Destination.LoginScreen
                ) {
                    composable<Destination.LoginScreen> {
                        val viewModel: LoginViewModel = viewModel(factory = viewModelFactory)
                        Box(
                            modifier = Modifier.fillMaxSize(),
                            contentAlignment = Alignment.Center
                        ) {
                            Button(onClick = { viewModel.login() }) {
                                Text(text = "Login")
                            }
                        }
                    }
                }

                navigation<Destination.HomeGraph>(
                    startDestination = Destination.HomeScreen
                ) {
                    composable<Destination.HomeScreen> {
                        val viewModel: HomeViewModel = viewModel(factory = viewModelFactory)
                        Column(
                            modifier = Modifier.fillMaxSize(),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {

                            Text(
                                modifier = Modifier.fillMaxWidth(),
                                text = viewModel.getGreeting(),
                                style = TextStyle(
                                    textAlign = TextAlign.Center,
                                    fontSize = 22.sp,
                                    color = Color.Black
                                )
                            )

                            Button(onClick = {
                                viewModel.navigationToDetails(
                                    UUID.randomUUID().toString()
                                )
                            }) {
                                Text(text = "Go to details")
                            }
                        }
                    }

                    composable<Destination.DetailsScreen> {
                        val viewModel: DetailsViewModel = viewModel(factory = viewModelFactory)
                        val args = it.toRoute<Destination.DetailsScreen>()
                        Column(
                            modifier = Modifier.fillMaxSize(),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {

                            Text(text = "ID:${args.id}")

                            Button(onClick = viewModel::goBack) {
                                Text(text = "Go back")
                            }
                        }
                    }
                }
            }
        }

    }

}