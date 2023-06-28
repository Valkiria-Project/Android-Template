package com.example.myapplication.data.remote.model

import com.example.myapplication.domain.deviceauth.model.BodyRowModel
import com.example.myapplication.domain.deviceauth.model.BodyRowTypeModel

sealed interface BodyRowResponse {
    val type: BodyRowTypeModel

    fun mapToDomain(): BodyRowModel
}
