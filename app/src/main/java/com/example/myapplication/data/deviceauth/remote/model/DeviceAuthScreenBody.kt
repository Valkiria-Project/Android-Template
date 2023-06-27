package com.example.myapplication.data.deviceauth.remote.model

data class DeviceAuthScreenBody(
    val params: Params
)

data class Params(
    val serial: String = "asd"
)