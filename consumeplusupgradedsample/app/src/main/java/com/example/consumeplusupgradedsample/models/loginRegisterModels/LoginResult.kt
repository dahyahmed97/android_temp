package com.example.consumeplusupgradedsample.models.loginRegisterModels

data class LoginResult(
    val activeFlag: Boolean,
    val authority: List<Authority>,
    val brcode: Int,
    val custno: Int,
    val email: String,
    val idno: String,
    val imei: Any,
    val initialLimit: Int,
    val langCode: String,
    val phone: String,
    val registrationStatus: Int,
    val roleId: Int,
    val token: String,
    val type: Int,
    val userName: String
)