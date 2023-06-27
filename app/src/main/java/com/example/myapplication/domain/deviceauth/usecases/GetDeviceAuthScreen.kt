package com.example.myapplication.domain.deviceauth.usecases

import androidx.annotation.CheckResult
import com.example.myapplication.commons.extensions.resultOf
import com.example.myapplication.domain.deviceauth.DeviceAuthRepository
import com.example.myapplication.domain.deviceauth.model.DeviceAuthScreenModel
import javax.inject.Inject

class GetDeviceAuthScreen @Inject constructor(
    private val deviceAuthRepository: DeviceAuthRepository
) {

    @CheckResult
    suspend operator fun invoke(serial: String): Result<DeviceAuthScreenModel> = resultOf {
        val fetchResult = deviceAuthRepository.getDeviceAuthScreen(serial)

        fetchResult
    }
}