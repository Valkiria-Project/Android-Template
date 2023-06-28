package com.example.myapplication.data.remote.model

import com.example.myapplication.domain.deviceauth.model.MarginModel

data class MarginResponse(
    val top: Int,
    val bottom: Int,
    val left: Int,
    val right: Int
)

fun MarginResponse.mapToDomain(): MarginModel = MarginModel(
    top = top,
    bottom = bottom,
    left = left,
    right = right
)
