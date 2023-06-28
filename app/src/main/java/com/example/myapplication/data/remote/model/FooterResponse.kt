package com.example.myapplication.data.remote.model

import com.example.myapplication.domain.deviceauth.model.FooterModel
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class FooterResponse(
    val leftButton: ButtonResponse? = null,
    val rightButton: ButtonResponse? = null
)

fun FooterResponse.mapToDomain(): FooterModel = FooterModel(
    leftButtonModel = leftButton?.mapToDomain(),
    rightButtonModel = rightButton?.mapToDomain()
)
