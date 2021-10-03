package com.example.consumeplusupgradedsample.network


import com.example.consumeplusupgradedsample.models.loginRegisterModels.LoginRegisterationModel
import com.example.consumeplusupgradedsample.models.loginRegisterModels.LoginRequestObject
import com.example.consumeplusupgradedsample.models.lookUpModels.LookUpModel
import dagger.Provides
import retrofit2.Response
import retrofit2.http.*


interface ApiService {
    @POST("aurMob/users/login")

    suspend fun login(@Body loginRequestBody: LoginRequestObject):Response<LoginRegisterationModel>

    @GET("aurMob/common/jobs")
    suspend fun getJops():Response<LookUpModel>

}