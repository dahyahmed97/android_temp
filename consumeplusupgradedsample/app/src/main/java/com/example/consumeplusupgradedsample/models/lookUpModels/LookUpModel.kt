package com.example.consumeplusupgradedsample.models.lookUpModels

data class LookUpModel(
    val messages: List<String>,
    val pagebale: Any,
    val result: List<Result>,
    val status: Int
)