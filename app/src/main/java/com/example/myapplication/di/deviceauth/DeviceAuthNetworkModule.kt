package com.example.myapplication.di.deviceauth

import com.example.myapplication.data.deviceauth.remote.DeviceAuthApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
object DeviceAuthNetworkModule {

    @Provides
    internal fun providesDeviceAuthApi(retrofit: Retrofit): DeviceAuthApi =
        retrofit.create(DeviceAuthApi::class.java)
}
