package com.example.myapplication.di.deviceauth

import com.example.myapplication.data.deviceauth.DeviceAuthRepositoryImpl
import com.example.myapplication.domain.deviceauth.DeviceAuthRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class DeviceAuthRepositoryModule {

    @Binds
    abstract fun bindDeviceAuthRepository(
        deviceAuthRepositoryImpl: DeviceAuthRepositoryImpl
    ): DeviceAuthRepository
}
