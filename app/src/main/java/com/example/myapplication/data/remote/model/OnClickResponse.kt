package com.example.myapplication.data.remote.model

import com.example.myapplication.domain.deviceauth.model.OnClickModel
import com.example.myapplication.domain.deviceauth.model.OnClickType
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class OnClickResponse(
    val type: OnClickType
)

fun OnClickResponse.mapToDomain(): OnClickModel = OnClickModel(
    type = this.type
)
