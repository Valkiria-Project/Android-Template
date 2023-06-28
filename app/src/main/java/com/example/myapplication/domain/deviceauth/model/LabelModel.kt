package com.example.myapplication.domain.deviceauth.model

import kotlinx.parcelize.IgnoredOnParcel
import kotlinx.parcelize.Parcelize

@Parcelize
data class LabelModel(
    val text: String,
    val style: String,
    val margin: MarginModel
) : BodyRowModel {

    @IgnoredOnParcel
    override val type: BodyRowTypeModel = BodyRowTypeModel.LABEL
}
