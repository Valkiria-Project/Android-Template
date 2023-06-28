package com.example.myapplication.domain.deviceauth.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class FooterModel(
    val leftButtonModel: ButtonModel?,
    val rightButtonModel: ButtonModel?
) : Parcelable
