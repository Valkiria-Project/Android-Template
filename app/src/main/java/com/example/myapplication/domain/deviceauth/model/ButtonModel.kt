package com.example.myapplication.domain.deviceauth.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ButtonModel(
    val label: String,
    val onClick: OnClickModel
) : Parcelable
