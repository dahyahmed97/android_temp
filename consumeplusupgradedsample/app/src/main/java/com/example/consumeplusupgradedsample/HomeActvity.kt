package com.example.consumeplusupgradedsample

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.ExperimentalUnitApi
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import coil.annotation.ExperimentalCoilApi
import com.example.consumeplusupgradedsample.ui.screens.homeScreen.HomeScreenView
import com.example.consumeplusupgradedsample.ui.screens.homeScreen.HomeScreenViewModel
import com.example.consumeplusupgradedsample.ui.screens.loginScreen.LoginPageView
import com.example.consumeplusupgradedsample.ui.screens.loginScreen.SignInScreenViewmodel
import com.example.consumeplusupgradedsample.ui.theme.ConsumeplusupgradedsampleTheme
import com.example.consumeplusupgradedsample.utils.BottomTabBar
import dagger.hilt.android.AndroidEntryPoint

@ExperimentalCoilApi
@ExperimentalUnitApi
@AndroidEntryPoint
class HomeActvity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            Scaffold(
                bottomBar = {BottomTabBar()}

            ) {
                NavigationComponent(navController,this)
            }
        }
    }

    @ExperimentalUnitApi
    @Composable
    fun NavigationComponent(navController: NavHostController, context: Context) {
        NavHost(
            navController = navController,
            startDestination = "Home"
        ) {
            composable("Home") {
                val viewmodel = hiltViewModel<HomeScreenViewModel>()
                HomeScreenView(context,navController,viewmodel)
            }

        }
    }
}


