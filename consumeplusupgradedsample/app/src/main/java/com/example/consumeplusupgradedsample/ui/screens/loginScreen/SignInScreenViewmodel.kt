package com.example.consumeplusupgradedsample.ui.screens.loginScreen

import android.content.Context
import android.content.Intent
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.unit.ExperimentalUnitApi
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavHostController
import coil.annotation.ExperimentalCoilApi
import com.example.consumeplusupgradedsample.HomeActvity
import com.example.consumeplusupgradedsample.models.loginRegisterModels.LoginRequestObject
import com.example.consumeplusupgradedsample.network.MainRepository
import com.example.consumeplusupgradedsample.utils.Constants
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignInScreenViewmodel @Inject constructor(
    private  val repo: MainRepository
) : ViewModel()  {
    var phoneNumberText = mutableStateOf("")
    var passwordText = mutableStateOf("")
    var isNextButtonEnabled = mutableStateOf(false)
    var isPasswordShown= mutableStateOf(false)
    var isAlertDialogVisible = mutableStateOf(false)
    var alertDialogMessage = mutableStateOf("")
    var loading = mutableStateOf(false)


    fun formValidation(phone:String?,password:String?){
        if(phone!=null){
            if (phone.length<=11)
                phoneNumberText.value=phone
        }
        if(password!=null){

            passwordText.value=password
        }
        isNextButtonEnabled.value = phoneNumberText.value.isNotEmpty() && passwordText.value.isNotEmpty()
    }

    fun showHidePassword(){
        isPasswordShown.value = isPasswordShown.value ==false
    }
    @ExperimentalCoilApi
    @ExperimentalUnitApi
    fun userLogin(context: Context, navHostController: NavHostController)
    {
        loading.value=true
        val loginRequestObj = LoginRequestObject(passwordText.value,phoneNumberText.value)
        viewModelScope.launch {
            repo.login(loginRequestObj).let {
                if(it.isSuccessful){
                 if(it.body()!!.status==1){
                     Constants.Token =it.body()!!.result.token
                     Constants.name = it.body()!!.result.userName
                     val intent = Intent (context,HomeActvity::class.java)
                     context.startActivity(intent)
                 }else{
                     isAlertDialogVisible.value=true
                     alertDialogMessage.value = it.body()!!.messages[0]
                 }
                }
            }
            loading.value =false

        }

    }
}