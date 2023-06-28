package com.example.myapplication.data.remote.model

import com.example.myapplication.domain.deviceauth.model.BodyRowModel
import com.example.myapplication.domain.deviceauth.model.BodyRowTypeModel
import com.example.myapplication.domain.deviceauth.model.KeyboardType
import com.example.myapplication.domain.deviceauth.model.TextFieldModel

data class TextFieldResponse(
    val hint: String,
    val keyboardType: KeyboardType,
    val regex: String,
    val margins: MarginResponse
) : BodyRowResponse {

    override val type: BodyRowTypeModel = BodyRowTypeModel.TEXT_FIELD

    override fun mapToDomain(): BodyRowModel = TextFieldModel(
        hint = hint,
        keyboardType = keyboardType,
        regex = regex,
        margins = margins.mapToDomain()
    )
}
