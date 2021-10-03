package com.example.consumeplusupgradedsample.models.loginRegisterModels

data class Authority(
    val endPoint: String,
    val funcAname: String,
    val funcEname: String,
    val funcId: Int,
    val isHomePage: Int,
    val isPublic: Int,
    val method: String,
    val roleAname: String,
    val roleEname: String,
    val roleId: Int
)