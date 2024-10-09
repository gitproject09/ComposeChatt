package com.supan.presentation.screens


import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.supan.presentation.theme.ComposeChatAppTheme
import com.supan.presentation.ui.MainActivity
import com.supan.presentation.ui.view_models.AuthViewModel
import com.supan.presentation.utiles.Routes
import kotlinx.coroutines.delay

@Composable
fun MainScreen(
    mainActivity: MainActivity,
    navController: NavHostController,
    authViewModel: AuthViewModel = hiltViewModel(),
) {

    ComposeChatAppTheme {

        if (authViewModel.getCurrentUser() == null) {
            WelcomeScreen(mainActivity)
            LaunchedEffect(true) {
                delay(1000)
                navController.navigate(Routes().loginRoute) {
                    launchSingleTop = true
                    restoreState = true
                    popUpTo(this.popUpToId) {
                        saveState = true
                    }
                    navController.popBackStack()

                }
            }
        } else {
            navController.navigate(Routes().homeRoute) {
                launchSingleTop = true
                restoreState = true
                popUpTo(this.popUpToId) {
                    saveState = true
                }
                navController.popBackStack()

            }
        }
    }
}

