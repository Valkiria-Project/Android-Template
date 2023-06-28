package com.example.myapplication.domain.deviceauth.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
sealed interface BodyRowModel : Parcelable {
    val type: BodyRowTypeModel
}
