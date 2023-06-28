package com.example.myapplication.domain.deviceauth.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class MarginModel(
    val top: Int,
    val bottom: Int,
    val left: Int,
    val right: Int
) : Parcelable
