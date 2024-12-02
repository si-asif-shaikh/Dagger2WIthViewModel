package com.gaming.dagger2.ui

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import com.gaming.dagger2.MyViewModel

@Composable
fun MyComposable(
    viewModelFactory: ViewModelProvider.Factory
) {
    val viewModel: MyViewModel = viewModel(factory = viewModelFactory)

    MainScreen(viewModel)
}

@Composable
fun MainScreen(viewModel: MyViewModel) {
    Text(
        text = viewModel.getGreeting(),
        fontSize = 22.sp,
        color = Color.White
    )
}