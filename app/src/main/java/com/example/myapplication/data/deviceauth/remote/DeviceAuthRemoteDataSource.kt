package com.example.myapplication.data.deviceauth.remote

import com.example.myapplication.commons.extensions.resultOf
import com.example.myapplication.data.deviceauth.remote.model.DeviceAuthScreenBody
import com.example.myapplication.data.deviceauth.remote.model.Params
import com.example.myapplication.data.deviceauth.remote.model.mapToDomain
import com.example.myapplication.domain.deviceauth.model.DeviceAuthScreenModel
import javax.inject.Inject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class DeviceAuthRemoteDataSource @Inject constructor(
    private val deviceAuthApi: DeviceAuthApi
) {

    suspend fun getDeviceAuthScreen(serial: String) : Result<DeviceAuthScreenModel> = resultOf {
        val response = withContext(Dispatchers.IO) {
            deviceAuthApi.getDeviceAuthScreen(DeviceAuthScreenBody(Params(serial = serial)))
        }

        val body = response.body()

        if (response.isSuccessful && body != null) {
            body.mapToDomain()
        } else {
            error("The retrieved response is not successful and/or body is empty")
        }
    }

}
