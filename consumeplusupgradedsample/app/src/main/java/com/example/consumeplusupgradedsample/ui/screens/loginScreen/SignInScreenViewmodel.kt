package com.example.consumeplusupgradedsample.ui.screens.loginScreen

import android.content.Context
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavHostController
import com.example.consumeplusupgradedsample.models.loginRegisterModels.LoginRequestObject
import com.example.consumeplusupgradedsample.network.MainRepository
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
    var alerDialogMessage = mutableStateOf("")
    var isloading = mutableStateOf(false)

    fun formValidation(phone:String?,password:String?){
        if(phone!=null){
            if (phone.length<=11)
                phoneNumberText.value=phone
        }
        if(password!=null){

            passwordText.value=password
        }
        isNextButtonEnabled.value = !phoneNumberText.value.isEmpty() && !passwordText.value.isEmpty()
    }

    fun showHidePassword(){
        isPasswordShown.value = isPasswordShown.value ==false
    }
    fun userLogin(context: Context , navHostController: NavHostController)
    {
        isloading.value=true;
        val loginRequestObj: LoginRequestObject = LoginRequestObject(passwordText.value,phoneNumberText.value)
        viewModelScope.launch {
            repo.login(loginRequestObj).let {
                if(it.isSuccessful){
                 if(it.body()!!.status==1){
                     navHostController.navigate("HomePage")
                 }else{
                     isAlertDialogVisible.value=true
                     alerDialogMessage.value = it.body()!!.messages[0]
                 }
                }
            }
            isloading.value =false

        }

    }
}