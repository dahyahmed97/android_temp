package com.example.consumeplusupgradedsample.models.loginRegisterModels


data class LoginRegisterationModel(
    val messages: List<String>,
    val pagebale: Any,
    val result: LoginResult,
    val status: Int
)