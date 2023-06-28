package com.example.myapplication.data.remote.model

import com.example.myapplication.domain.deviceauth.model.BodyRowModel
import com.example.myapplication.domain.deviceauth.model.BodyRowTypeModel
import com.example.myapplication.domain.deviceauth.model.LabelModel

data class LabelResponse(
    val text: String,
    val style: String,
    val margins: MarginResponse
) : BodyRowResponse {

    override val type: BodyRowTypeModel = BodyRowTypeModel.LABEL

    override fun mapToDomain(): BodyRowModel = LabelModel(
        text = text,
        style = style,
        margin = margins.mapToDomain()
    )
}