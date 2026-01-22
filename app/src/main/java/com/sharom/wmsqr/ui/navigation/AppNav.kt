package com.sharom.wmsqr.ui.navigation


import LoginScreen
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.sharom.wmsqr.ui.auth.RegisterScreen
import com.sharom.wmsqr.ui.main.MainScreen

@Composable
fun AppNav (){
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Routes.LOGIN
    ){

        composable(Routes.LOGIN) {

            LoginScreen(
                onLoginSuccess = {
                    navController.navigate(Routes.MAIN){
                        popUpTo(Routes.LOGIN) {inclusive = true}
                    }
                },

                onRegisterClick = {
                    navController.navigate(Routes.REGISTER)
                }

            )
        }

        composable(Routes.REGISTER) {
            RegisterScreen(
                onRegisterSuccess = {
                    navController.popBackStack() // назад на Login
                }
            )
        }


        composable(Routes.MAIN) {
            MainScreen(
                onLogout = {
                    navController.navigate(Routes.LOGIN) {
                        popUpTo(Routes.MAIN) { inclusive = true }
                    }
                }
            )
            }

    }
}