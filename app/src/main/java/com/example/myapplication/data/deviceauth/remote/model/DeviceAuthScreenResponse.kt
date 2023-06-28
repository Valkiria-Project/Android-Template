package com.example.myapplication.data.deviceauth.remote.model

import com.example.myapplication.data.remote.model.BodyRowResponse
import com.example.myapplication.data.remote.model.FooterResponse
import com.example.myapplication.data.remote.model.HeaderResponse
import com.example.myapplication.data.remote.model.mapToDomain
import com.example.myapplication.domain.deviceauth.model.DeviceAuthScreenModel
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class DeviceAuthScreenResponse(
    val header: HeaderResponse? = null,
    val body: List<BodyRowResponse>? = null,
    val footer: FooterResponse? = null
)

fun DeviceAuthScreenResponse.mapToDomain(): DeviceAuthScreenModel = DeviceAuthScreenModel(
    headerModel = header?.mapToDomain(),
    body = body?.map { it.mapToDomain() } ?: error("body cannot be null"),
    footerModel = footer?.mapToDomain()
)
