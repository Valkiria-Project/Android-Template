package com.example.myapplication.data.remote.model

import com.example.myapplication.domain.deviceauth.model.ButtonModel
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ButtonResponse(
    val label: String,
    val onClick: OnClickResponse
)

fun ButtonResponse.mapToDomain(): ButtonModel = ButtonModel(
    label = this.label,
    onClick = this.onClick.mapToDomain()
)
