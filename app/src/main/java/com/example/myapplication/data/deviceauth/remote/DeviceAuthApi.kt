package com.example.myapplication.data.deviceauth.remote

import com.example.myapplication.data.deviceauth.remote.model.DeviceAuthScreenBody
import com.example.myapplication.data.deviceauth.remote.model.DeviceAuthScreenResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface DeviceAuthApi {

    @POST("sisem-api/v1/screen/deviceAuth")
    suspend fun getDeviceAuthScreen(
        @Body deviceAuthScreenBody: DeviceAuthScreenBody
    ): Response<DeviceAuthScreenResponse>
}
