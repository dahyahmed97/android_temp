package com.example.consumeplusupgradedsample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.ExperimentalUnitApi
import coil.annotation.ExperimentalCoilApi
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
            Scaffold(
                bottomBar = {BottomTabBar()}

            ) {

            }
        }
    }
}


