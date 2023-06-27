package com.example.myapplication.data.remote.model

import com.example.myapplication.domain.deviceauth.model.HeaderModel
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class HeaderResponse(
    val title: String
)

fun HeaderResponse.mapToDomain(): HeaderModel = HeaderModel(
    title = this.title
)
