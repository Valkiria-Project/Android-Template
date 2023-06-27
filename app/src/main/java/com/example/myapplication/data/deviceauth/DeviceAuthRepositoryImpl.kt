package com.example.myapplication.data.deviceauth

import com.example.myapplication.data.deviceauth.remote.DeviceAuthRemoteDataSource
import com.example.myapplication.domain.deviceauth.DeviceAuthRepository
import com.example.myapplication.domain.deviceauth.model.DeviceAuthScreenModel
import javax.inject.Inject

class DeviceAuthRepositoryImpl @Inject constructor(
    private val deviceAuthRemoteDataSource: DeviceAuthRemoteDataSource
) : DeviceAuthRepository {

    override suspend fun getDeviceAuthScreen(serial: String): DeviceAuthScreenModel =
        deviceAuthRemoteDataSource.getDeviceAuthScreen(serial = serial).getOrThrow()
}
