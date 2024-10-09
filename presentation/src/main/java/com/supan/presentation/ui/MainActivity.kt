package com.supan.presentation.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.supan.presentation.screens.ChatScreen
import com.supan.presentation.screens.home_screen.HomeScreen
import com.supan.presentation.screens.auth.LoginScreen
import com.supan.presentation.screens.MainScreen
import com.supan.presentation.screens.auth.SignUpScreen
import com.supan.presentation.utiles.Routes
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            App(this)
        }
    }
}

@Composable
fun App(mainActivity: MainActivity) {
     val mainNavController = rememberNavController()


        NavHost(
            navController = mainNavController,
            startDestination = Routes().mainRoute
        ) {

            composable(route = Routes().mainRoute) {
                MainScreen(mainActivity, mainNavController)

            }
            composable(route = Routes().loginRoute) {
                LoginScreen(mainNavController = mainNavController)
            }

            composable(route = Routes().signUpRoute) {
                SignUpScreen(mainNavController = mainNavController)
            }

            composable(route = Routes().homeRoute) {
                HomeScreen(mainNavController = mainNavController)
            }

            composable(route = Routes().chatScreen + "/{userId}") { navBackStack ->
                val userId = navBackStack.arguments?.getString("userId")

                ChatScreen(userId!!)
            }


        }


}




