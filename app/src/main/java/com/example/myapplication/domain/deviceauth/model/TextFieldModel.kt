package com.example.myapplication.domain.deviceauth.model

import kotlinx.parcelize.IgnoredOnParcel
import kotlinx.parcelize.Parcelize

@Parcelize
data class TextFieldModel(
    val hint: String,
    val keyboardType: KeyboardType,
    val regex: String,
    val margins: MarginModel
) : BodyRowModel {

    @IgnoredOnParcel
    override val type: BodyRowTypeModel = BodyRowTypeModel.TEXT_FIELD
}
