package com.example.myapplication.domain.deviceauth.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
enum class BodyRowTypeModel : Parcelable {
    LABEL,
    TEXT_FIELD
}
