package com.example.myapplication.domain.deviceauth

import com.example.myapplication.domain.deviceauth.model.DeviceAuthScreenModel

interface DeviceAuthRepository {

    suspend fun getDeviceAuthScreen(serial: String): DeviceAuthScreenModel
}
