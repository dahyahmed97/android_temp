package com.example.consumeplusupgradedsample.ui.screens.homeScreen

import androidx.lifecycle.ViewModel
import com.example.consumeplusupgradedsample.network.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel  @Inject constructor(
    private  val repo: MainRepository
) : ViewModel()  {
}