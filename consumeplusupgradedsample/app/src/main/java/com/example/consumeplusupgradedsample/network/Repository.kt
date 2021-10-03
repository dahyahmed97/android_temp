package com.example.consumeplusupgradedsample.network


import com.example.consumeplusupgradedsample.models.loginRegisterModels.LoginRegisterationModel
import com.example.consumeplusupgradedsample.models.loginRegisterModels.LoginRequestObject
import com.example.consumeplusupgradedsample.models.lookUpModels.LookUpModel
import retrofit2.Response
import javax.inject.Inject

class MainRepository @Inject constructor(
    private val apiService:ApiService
){
    suspend fun login(loginRequestObject: LoginRequestObject):Response<LoginRegisterationModel> = apiService.login(loginRequestObject)

    suspend fun getJops():Response<LookUpModel> = apiService.getJops()


}