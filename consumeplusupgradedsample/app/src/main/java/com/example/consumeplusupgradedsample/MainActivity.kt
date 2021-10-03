package com.example.consumeplusupgradedsample

import androidx.hilt.navigation.compose.hiltViewModel
import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.ExperimentalUnitApi
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.consumeplusupgradedsample.ui.screens.loginScreen.LoginPageView
import com.example.consumeplusupgradedsample.ui.screens.loginScreen.SignInScreenViewmodel
import com.example.consumeplusupgradedsample.ui.theme.ConsumeplusupgradedsampleTheme

class MainActivity : ComponentActivity() {
    @ExperimentalUnitApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            ConsumeplusupgradedsampleTheme {
                // A surface container using the 'background' color from the theme
                Scaffold {
                    NavigationComponent(navController,this)
                }
            }
        }
    }
}

@ExperimentalUnitApi
@Composable
fun NavigationComponent(navController: NavHostController ,context: Context) {
    NavHost(
        navController = navController,
        startDestination = "SignIn"
    ) {
        composable("SignIn") {
            val viewmodel = hiltViewModel<SignInScreenViewmodel>()
            LoginPageView(context,navController,viewmodel)
        }

    }
}
